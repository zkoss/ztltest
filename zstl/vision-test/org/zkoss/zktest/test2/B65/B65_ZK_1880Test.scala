package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1880.zul")
class B65_ZK_1880Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="menu image" contentType="text/html;charset=UTF-8"?>
<zk>
	<window border="normal">
		<menubar width="100%">
			<menu label="Project" image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
				<menupopup/>
			</menu>
			<menu label="Help" image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
				<menupopup/>
			</menu>
			<menu image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
				<menupopup/>
			</menu>
		</menubar>
		<label>The complete images of the menu should be show on ie9,10,11;</label>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}