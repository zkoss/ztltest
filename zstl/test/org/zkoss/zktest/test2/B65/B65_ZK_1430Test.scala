package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZK

@Tags(tags = "B65-ZK-1430.zul")
class B65_ZK_1430Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
<label multiline="true">
Click the button, listbox will display and show 5 rowsm. 
The bandpopup size must be the same as listbox's size.

IE6 / IE7 only.
</label>
<separator />
<bandbox width="150px" autodrop="true" buttonVisible="true" mold="rounded">
	<bandpopup hflex="min" vflex="min">
		<listbox width="200px" rows="5">
			<listitem>
				<listcell label="0" />
			</listitem>
			<listitem>
				<listcell label="1" />
			</listitem>
			<listitem>
				<listcell label="2" />
			</listitem>
			<listitem>
				<listcell label="3" />
			</listitem>
			<listitem>
				<listcell label="4" />
			</listitem>
			<listitem>
				<listcell label="5" />
			</listitem>
			<listitem>
				<listcell label="6" />
			</listitem>
			<listitem>
				<listcell label="7" />
			</listitem>
			<listitem>
				<listcell label="8" />
			</listitem>
			<listitem>
				<listcell label="9" />
			</listitem>
			<listitem>
				<listcell label="10" />
			</listitem>
			<listitem>
				<listcell label="11" />
			</listitem>
		</listbox>
	</bandpopup>
</bandbox>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-bandbox-button"))
        waitResponse()
        val height = if (ZK.is("ff") || ZK.is("opera") || ZK.is("safari") || ZK.is("chrome")) {
          jq(".z-listbox-body").height()
        } else {
          jq(".z-listbox-body").height() - 2
        }

        verifyTrue("The bandpopup size must be the same as listbox's size.", height == jq(".z-listitem").height() * 5)
      })

  }
}