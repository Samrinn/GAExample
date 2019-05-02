import scala.collection.mutable.StringBuilder
import scala.util.Random;

class Individual(variables:scala.collection.mutable.IndexedSeq[Double]) {

  private var value = 0.0;

  private val dejong = (x:IndexedSeq[Double]) => x.map(y=>y*y).sum;

  private def eval(x:IndexedSeq[Double]):Double = dejong(x);

  def this(size:Int) = this(scala.collection.mutable.IndexedSeq( (for(i <- 1 to size) yield new Random().nextDouble()).toList:_*));

  def getVariables() = variables;

  def getValue() = value;

  def eval() {
    value = eval(variables);
  }

  def mutate() {
    val random = new Random();
    val index = random.nextInt(variables.length);
    val newVal:Double = variables(index) * random.nextGaussian();
    variables.update(index, newVal);
  }

  override def toString() = {
    val builder = new StringBuilder();
    val df = new java.text.DecimalFormat("#########.##########")
    variables.foreach(arg => builder.append(df.format(arg)+" "));
    builder.append(df.format(value));
    builder.toString();
  }
}
