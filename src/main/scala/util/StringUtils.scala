package util

object StringUtils {

  def substringAfter(s: String, k: String) = {
    s.indexOf(k) match {
      case -1 => ""
      case i => s.substring(i + k.length)
    }
  }

  def substringBeforeLast(s: String, k: String) = {
    s.lastIndexOf(k) match {
      case -1 => s
      case i => s.substring(0, i)
    }
  }


  def bytesToSize(bytes: Long) = {
    val Sizes = Seq("Bytes", "KB", "MB", "GB", "TB")
    if (bytes == 0) {
      "0 Byte"
    } else {
      val i = Math.floor(Math.log(bytes) / Math.log(1024)).toInt
      Math.round(bytes / Math.pow(1024, i)) + " " + Sizes(i)
    }
  }


  def subId(id: String) = id.replaceFirst("sha256:","").take(12)

  // quick hack to format to without using java DecimalFormat #.##%
  def toPercent(num:Double):String = {
    ((num * 100).toInt / 100).toString + "%"
  }
}
