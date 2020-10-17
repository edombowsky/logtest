package tinylog.test

class TestClass {

  def sayHello(name: String): Unit = {

    scribe.info(s"hello $name from ${this.getClass.getName}")
  }
}
