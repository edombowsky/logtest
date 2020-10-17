lazy val root = project
  .in(file("."))
  .settings(
    name := "logtest",
    description := "Experimant with scribe",
    version := "0.1.0",
    scalaVersion := "2.13.3"
  )

//name := "logtest"
//
//version := "0.1"
//
//scalaVersion := "2.13.3"

// scalafmt: { align.preset = most, danglingParentheses.preset = false }
libraryDependencies += "com.outr" %% "scribe" % "2.7.12"
// scalafmt: { align.preset = some, danglingParentheses.preset = true } (back to defaults)
