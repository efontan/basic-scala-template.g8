import sbtrelease._
import sbt._
import Keys._
import ReleasePlugin.autoImport._
import ReleaseStateTransformations._

object Release {
	
	val settings = Seq(

		// See: http://www.scala-sbt.org/0.13/docs/Publishing.html
		// http://www.scala-sbt.org/0.13/docs/Using-Sonatype.html
		publishTo := {
			val nexus = "https://oss.sonatype.org/"
			if (isSnapshot.value) {
				Some("snapshots" at nexus + "content/repositories/snapshots")
			}
			else {
				Some("releases"  at nexus + "service/local/staging/deploy/maven2")
			}
		},

		publishMavenStyle := true,
		publishArtifact in Test := false,
		credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
		// Add pomExtra info if it's necesary

		releaseVersion := { ver =>
			Version(ver).map(_.withoutQualifier.string).getOrElse(versionFormatError)
		},
		
		releaseNextVersion := { ver =>
			Version(ver).map(_.bumpBugfix.asSnapshot.string).getOrElse(versionFormatError)
		},
		
		releaseCrossBuild := false,
		
		releaseTagName := (version in ThisBuild).value,
		
		// release steps
		releaseProcess := Seq[ReleaseStep](
			checkSnapshotDependencies,
			inquireVersions,
			runTest,
			setReleaseVersion,
			commitReleaseVersion,
			tagRelease,
			publishArtifacts,
			setNextVersion,
			commitNextVersion,
			pushChanges
		),
		
		scalacOptions ++= Seq(
			"-unchecked",
			"-deprecation",
			"-Xlint",
			"-Ywarn-dead-code",
			"-Ywarn-unused",
			"-Ywarn-unused-import",
			"-language:_",
			"-encoding", "UTF-8"
		)
	)
}
