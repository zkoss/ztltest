package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2214.zul")
class B65_ZK_2214Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window title="IE8 only" border="normal">
	<label>
		Should see the scrollbar in IE8.
	</label>
	<grid width="500px">
		<frozen columns="2"/>
		<columns>
			<column label="A" visible="false"/>
			<column label="B"/>
			<column label="C"/>
			<column label="D"/>
			<column label="E"/>
		</columns>
		<rows>
			<row>
				<label value="a1"/>
				<label value="b1"/>
				<label value="c1"/>
				<label value="d1"/>
				<label value="e1"/>
			</row>
			<row>
				<label value="a2"/>
				<label value="b2"/>
				<label value="c2"/>
				<label value="d2"/>
				<label value="e2"/>
			</row>
		</rows>
	</grid>
</window>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}