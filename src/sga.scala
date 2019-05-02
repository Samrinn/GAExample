object sga extends App {
  val populationSize = 100;
  val compareFunction = (x:Individual, y:Individual) => x.getValue() < y.getValue();
  println("Population Created");
  var population:IndexedSeq[Individual] =  new Population(populationSize,2).getPopulation();
  val parentChoose:ParentChoose = new ParentChoose();
  val crossover:ArithmeticCrossover = new ArithmeticCrossover();
  print(population.length);
  for(generation <- 1 to 20) {
    val parent1:Individual = parentChoose.parents(population)(0);
    val parent2:Individual = parentChoose.parents(population)(1);
    population = population ++ crossover.crossover(parent1, parent2);
    population.foreach(individual => individual.mutate());
    population.foreach(individual => individual.eval());
    population.sortWith(compareFunction);
    population = population.filter( (x:Individual) => population.indexOf(x) < populationSize).sortWith(compareFunction);

  }
  println(population.length);

  population.foreach((x:Individual)=>println(x));
}
