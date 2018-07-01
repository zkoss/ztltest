package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test

@Tags(tags = "Touch,Android")
class B65_ZK_1404Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	1. iPad/Android only
	2. Should see splitter size correctly.
	</label>
	<hbox>
		<panel title="Splitter, Default Mold" sclass="center-bg-win"
			framable="true" border="normal" height="300px" width="300px">
			<panelchildren>
    			<hbox spacing="0" height="100%">
    				<vbox spacing="0" width="100%" height="100%">
    				Vbox Content
    				<splitter collapse="before" />
    				Vbox Content
    				</vbox>
    				<splitter collapse="before" />
    				Hbox Content
    			</hbox>
			</panelchildren>
		</panel>
		<window title="Splitter, Default Mold" sclass="center-bg-win"
			border="normal" height="300px" width="300px">
			<hbox spacing="0" height="100%">
				<vbox spacing="0" width="100%" height="100%">
					Vbox Content
					<splitter collapse="before" />
					Vbox Content
				</vbox>
				<splitter collapse="before" />
				Hbox Content
			</hbox>
		</window>
	</hbox>
</zk>

    """

    runZTL(zscript,
      () => {
        
        verifyEquals("Should see splitter size correctly.", jq(".z-splitter-horizontal:eq(0)").height(), jq(".z-panelchildren").height())
        verifyEquals("Should see splitter size correctly.", jq(".z-splitter-horizontal:eq(1)").height(), jq(jq(".z-window").toWidget().$n("cave")).height())
        
        var hgh0  = jq("td:contains(Vbox):eq(0)").height()
        verifyTrue("Should see splitter size correctly.", hgh0 > 100)
        verifyEquals("Should see splitter size correctly.", hgh0, jq("td:contains(Vbox):eq(1)").height())
        
        var hgh2  = jq("td:contains(Vbox):eq(2)").height()        
        verifyTrue("Should see splitter size correctly.", hgh2 > 100)
        verifyEquals("Should see splitter size correctly.", hgh2, jq("td:contains(Vbox):eq(2)").height())
        
        verifyTrue("Should see splitter size correctly.", hgh0 > 100)
        verifyTrue("Should see splitter size correctly.", hgh0 > 100)

      })

  }
}
