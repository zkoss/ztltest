package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1948.zul")
class B65_ZK_1948Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	Open the "test menu" in IE8, should not see a horizontal scroll bar showed.
	<div width="100%" align="right">
		<menubar width="100%" autodrop="true">
			<menu label="test menu">
				<menupopup>
					<menuitem label="sub menu item 1"></menuitem>
					<menuseparator></menuseparator>
					<menuitem label="sub menu item 2"></menuitem>
				</menupopup>
			</menu>
		</menubar>
	</div>
</zk>"""  
  runZTL(zscript,
    () => {
      mouseOver(jq(".z-menu").toWidget().$n("a"))
      waitResponse()
      verifyImage()
    })
    
  }
}