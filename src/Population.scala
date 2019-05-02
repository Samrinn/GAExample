class Population(size:Int, varSize:Int) {
  private val population:IndexedSeq[Individual] = for(i <- 1 to size) yield new Individual(varSize);

  def getPopulation() = population;
}
