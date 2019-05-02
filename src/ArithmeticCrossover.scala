import scala.util.Random;

class ArithmeticCrossover {
  //Offspring1 = a * Parent1 + (1- a) * Parent2
  //Offspring2 = (1 – a) * Parent1 + a * Parent2
  val off1 = (x:Double, y:Double, factor:Double) => factor * x + (1-factor) * y;
  val off2 = (x:Double, y:Double, factor:Double) => (1 - factor) * x + factor * y;

  def crossover(parent1:Individual, parent2:Individual) = {
    val factor = new Random().nextInt();
    var offspring1=scala.collection.mutable.IndexedSeq[Double]();
    var offspring2=scala.collection.mutable.IndexedSeq[Double]();
    for(i<-0 to parent1.getVariables().size-1) {
      offspring1 = offspring1 :+ off1(parent1.getVariables()(i),parent2.getVariables()(i),factor);
      offspring2 = offspring2 :+ off2(parent1.getVariables()(i),parent2.getVariables()(i),factor);
    }
    IndexedSeq(new Individual(offspring1), new Individual(offspring2));
  }
}
