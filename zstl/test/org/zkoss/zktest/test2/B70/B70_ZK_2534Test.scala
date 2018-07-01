package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2534.zul")
class B70_ZK_2534Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<zk>
	<custom-attributes org.zkoss.zul.listbox.rod="false" />
	<listbox multiple="true" checkmark="true">
		<listhead>
			<listheader hflex="min" />
			<listheader label="Name" />
		</listhead>
		<listitem>
			<listcell />
			<listcell label="David" />
		</listitem>
		<listitem checkable="false">
			<listcell />
			<listcell label="Thomas" />
		</listitem>
		<listitem>
			<listcell />
			<listcell label="Lukas" />
		</listitem>
		<listitem checkable="false">
			<listcell />
			<listcell label="Jens" />
		</listitem>
	</listbox>
</zk>
    
"""
    runZTL(zscript,
      () => {
        var check = jq(".z-listheader-checkable");
        click(check);
        waitResponse();
        var evens = jq(".z-listitem:even");
        for (i <- 0 to 1) {
          var even = evens.eq(i);
          verifyContains(even.attr("class"), "z-listitem-selected")
        }
      })
  }
}