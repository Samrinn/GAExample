import scala.util.Random;

class ParentChoose {
  def parents(population:IndexedSeq[Individual]):IndexedSeq[Individual] = {
    val parent1:Individual = population(new Random().nextInt(population.length));
    val parent2:Individual = population(new Random().nextInt(population.length));
    IndexedSeq(parent1, parent2);
  }
}
