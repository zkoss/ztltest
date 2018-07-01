/* B50_ZK_543Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Dec 05 11:33:25 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-543
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-543.zul,B,E,Listbox,sizedByContent,VisionTest")
class B50_ZK_543Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
			<div>There should no extra space below the last row of the listbox.</div>
				<listbox id="listbox" width="400px" sizedByContent="true"
					rows="3">
					<listhead >
						<listheader label="Test" />
					</listhead>
					<listitem>
						<listcell>
							<label value="1" />
						</listcell>
						<listcell>
							<label value="DEQU8978163" />
						</listcell>
					</listitem>
					<listitem>
						<listcell>
							<label value="11-Oct-25 1929" />
						</listcell>
						<listcell>
							<label value="DEQU8978163" />
						</listcell>
					</listitem>
					<listitem>
						<listcell>
							<label value="11-Oct-25 1929" />
						</listcell>
						<listcell>
							<label value="TBBS15243100" />
						</listcell>
						<listcell>
							<label value="APLxzxzxzxzxz" />
						</listcell>
						<listcell>
							<label value="V152sfsfs" />
						</listcell>
						<listcell>
							<label value="V152" />
						</listcell>
						<listcell>
							<label value="Export" />
						</listcell>
					</listitem>
				</listbox>
			</zk>

    """
    runZTL(zscript, () => {
      var listbox: Widget = engine.$f("listbox");

      // IE may have few pixel below
      verifyTrue("the body height should equal to cave height",
        Math.abs(jq(listbox.$n("body")).outerHeight() - jq(listbox.$n("cave")).outerHeight()) < 3);
    })
  }
}