package basics.recursion

object ShortestPathMaze {

  def main(args: Array[String]): Unit = {
    println(shortestPath(maze,0,0,0,2))
  }

  val maze = Array(
    Array( 0,-1, 0, 0, 0,-1),
    Array( 0,-1, 0,-1, 0,-1),
    Array( 0, 0, 0,-1, 0,-1),
    Array(-1,-1,-1,-1, 0, 0)
  )

  def shortestPath(maze: Array[Array[Int]],x:Int,y:Int,ex:Int,ey:Int): Int = {
    if(x == ex && y == ey) 0
    else if (x < 0 || x >= maze.length || y < 0 || y >= maze(x).length || maze(x)(y)<0){
      1000000000
    } else {
      maze(x)(y) = -2
      val ret = ( shortestPath(maze, x+1,y,   ex, ey) min
                  shortestPath(maze, x-1,y,   ex, ey) min
                  shortestPath(maze, x  ,y+1, ex, ey) min
                  shortestPath(maze, x  ,y-1, ex, ey)) + 1
        maze(x)(y) = 0
      ret
    }
  }

}
