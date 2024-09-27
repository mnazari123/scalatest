package testhello
import scala.collection.mutable
import scala.io.StdIn
import scala.sys.process._
import mainargs.{main, arg, ParserForMethods, Flag}
import org.log4s._
import org.slf4j.LoggerFactory
import org.knowm.xchart.{PieChartBuilder, SwingWrapper}

object Main{

  var cloudSize = 10
  var minLength = 6
  var windowSize = 1000
  var everyKSteps = 10
  var minFrequency = 3

  @main
  def run(
    @arg(short = 'c', doc = "size of the sliding word cloud") cloudSize: Int = 10,
    @arg(short = 'l', doc = "minimum word length to be considere") minLength: Int = 6,
    @arg(short = 'w', doc = "size of the sliding FIFO queue") windowSize: Int = 1000,
    @arg(short = 's', doc = "number of steps between word cloud updates") everyKSteps: Int = 10,
    @arg(short = 'f', doc = "minimum frequency for a word to be included in the cloud") minFrequency: Int = 3): Unit = {
      this.cloudSize = cloudSize
      this.minLength = minLength
      this.windowSize = windowSize
      this.everyKSteps = everyKSteps
      this.minFrequency = minFrequency
      println(f"howMany=$cloudSize minLength=$minLength lastNWords=$windowSize everyKSteps=$everyKSteps minFrequency=$minFrequency")
  }

  def main(args: Array[String]): Unit = ParserForMethods(this).runOrExit(args)

    println(s"Cloud size: $cloudSize, Min length: $minLength, Window size: $windowSize")


    // Sliding window to track the last N words
    val window = mutable.Queue[String]()

    // Map to track word frequencies within the window
    val wordFrequency = mutable.Map[String, Int]().withDefaultValue(0)

    def updateWindow(word: String): Unit = {
      window.enqueue(word)
      wordFrequency(word) += 1

      // Remove the oldest word if the window exceeds size
      if (window.size > windowSize) {
        val oldWord = window.dequeue()
        wordFrequency(oldWord) -= 1
        if (wordFrequency(oldWord) == 0) {
          wordFrequency.remove(oldWord)
        }
      }
    }

    // Function to print the word cloud
    def printWordCloud(): Unit = {
      // val sortedWords = wordFrequency.toSeq.sortBy(-_._2).take(cloudSize)

      // Sort words by frequency and apply filters (minFrequency and cloudSize)
      val sortedWords = wordFrequency.toSeq
        .filter(_._2 >= minFrequency) // Only include words with sufficient frequency
        .sortBy(-_._2)
        .take(cloudSize)

      val wordCloud = sortedWords.map { case (word, freq) => s"$word: $freq" }.mkString(" ")
      println(wordCloud)

      // Update chart for dynamic visualization
      updateChart(sortedWords)
    }

    // Create the chart and GUI
    val chart = new PieChartBuilder().width(800).height(600).title("Word Cloud").build()
    val sw = new SwingWrapper(chart)
    sw.displayChart()
    // Function to update the dynamic chart visualization
    def updateChart(sortedWords: Seq[(String, Int)]): Unit = {
      chart.getSeriesMap.clear() // Clear the previous chart
      sortedWords.foreach { case (word, freq) =>
        chart.addSeries(word, freq)
      }
      sw.repaintChart() // Refresh the chart window
    }

    var steps = 0
    
    val lines = scala.io.Source.stdin.getLines()
    val words = 
      import scala.language.unsafeNulls
      lines.flatMap(l => l.split("(?U)[^\\p{Alpha}0-9']+"))
      .map(_.toLowerCase)
      .filter(_.length >= minLength)
    words.foreach { word =>
      updateWindow(word)
      steps += 1
      // if (window.size >= windowSize) {
      //   printWordCloud()
      // }
      // Update and print word cloud every `everyKSteps`
      if (window.size >= windowSize && steps % everyKSteps == 0) {
        printWordCloud()
      }
    }
}