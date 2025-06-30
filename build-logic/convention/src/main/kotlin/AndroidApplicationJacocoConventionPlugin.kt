import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.heydenapps.arrowwords.buildlogic.configureJacoco
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

/**
 * @author Ludovic Roland
 * @since 2025.13.18
 */
class AndroidApplicationJacocoConventionPlugin : Plugin<Project> {
  
  override fun apply(target: Project) {
    with(target) {
      apply(plugin = "jacoco")
      
      val androidExtension = extensions.getByType<ApplicationExtension>()
      
      androidExtension.buildTypes.configureEach {
        enableAndroidTestCoverage = true
        enableUnitTestCoverage = true
      }
      
      configureJacoco(extensions.getByType<ApplicationAndroidComponentsExtension>())
    }
  }
  
}
