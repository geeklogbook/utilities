package stackoverflow.findFile

import java.io.File

import scala.collection.immutable.Map

object FindFiles extends App {

  val sites = Seq("mla","mlb","mlu")

  def existFiles(site:String, date: String): Unit ={
    //Parsing Date string
    val year  = date.substring(0,4)
    val month = date.substring(4,6)
    val day   = date.substring(6,8)

    //Working with the path
    val path  =  System.getProperty("user.dir") + "\\src\\main\\scala\\practise\\findFile\\"+ "market" + site +"\\data\\Deltas"
    val finalPath = path +"\\"+year+"\\"+month+"\\"+day+"\\"+"DatosItems"

    //Working with the file
    val dir = new File(finalPath)
    val listFiles = dir.listFiles()

    //Test if the file "_SUCCESS" is in the filname
    listFiles.foreach(file => if(file.getName.equals("_SUCCESS")) println("Site: " + site + " - " + "Date:" + date))
  }

  sites.map(x => existFiles(x, "20190208"))

}
