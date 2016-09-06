import sbt.Keys._
import sbt._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import sbtbuildinfo.Plugin._

import scalariform.formatter.preferences._

object Build extends sbt.Build {
	
	import Dependencies._

	lazy val commonSettings = Seq(
	  organization := "$organization$",
	  version := "$version$",
	  name := "$name$",
	  scalaVersion := "$scala_version$"
	)

	lazy val root = Project("$name$", base = file("."))
	.settings(commonSettings: _*)
	.settings(resolvers ++= repositories)
	.settings(libraryDependencies ++= projectDependencies)
	.settings(org.scalastyle.sbt.ScalastylePlugin.projectSettings: _*)
	.settings(buildInfoSettings ++ Seq(
		sourceGenerators in Compile <+= buildInfo,
		buildInfoKeys := Seq[BuildInfoKey](name, version),
		buildInfoPackage := "$organization$.$name$"
	): _*)
	.settings(Release.settings: _*)
	.settings(initialCommands := "import $organization$.$name$._")

	// Scalariform plugin
	lazy val formatSettings = SbtScalariform.scalariformSettings ++ Seq(
		ScalariformKeys.preferences in compile := formattingPreferences,
		ScalariformKeys.preferences in test := formattingPreferences
	)
	
	def formattingPreferences =
		FormattingPreferences()
			.setPreference(RewriteArrowSymbols, false)
			.setPreference(AlignParameters, false)
			.setPreference(AlignSingleLineCaseStatements, true)
			.setPreference(DoubleIndentClassDeclaration, true)
}
