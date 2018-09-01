/* B50_3293724Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3293724Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Click on "Hide 1". You should see item 5 left. Otherwise it is a bug.</li>
			<li>Click on "Show 1". You should see all items. Otherwise it is a bug.</li>
			<li>Click on "Hide 2". You should see item 1,4,5 left. Otherwise it is a bug.</li>
			<li>Click on "Show 2". You should see all items again. Otherwise it is a bug.</li>
		</ol>
	]]></html>
	<div>
		<button label="Hide 1" width="70px" onClick="t1.visible = false" />
		<button label="Hide 2" width="70px" onClick="t2.visible = false" />
	</div>
	<div>
		<button label="Show 1" width="70px" onClick="t1.visible = true" />
		<button label="Show 2" width="70px" onClick="t2.visible = true" />
	</div>
	<tree id="tree" rows="12">
		<treechildren>
			<treeitem id="t1">
				<treerow>
					<treecell>
						<label value="item1" />
					</treecell>
				</treerow>
				<treechildren>
					<treeitem id="t2">
						<treerow>
							<treecell>
								<label value="item2" />
							</treecell>
						</treerow>
						<treechildren>
							<treeitem id="t3">
								<treerow>
									<treecell>
										<label value="item3" />
									</treecell>
								</treerow>
							</treeitem>
						</treechildren>
					</treeitem>
					<treeitem id="t4">
						<treerow>
							<treecell>
								<label value="item4" />
							</treecell>
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
			<treeitem id="t5">
				<treerow>
					<treecell>
						<label value="item5" />
					</treecell>
				</treerow>
			</treeitem>
		</treechildren>
	</tree>
</zk>

		"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    val t1 = ztl$engine.$f("t1")
    val t2 = ztl$engine.$f("t2")
    val t3 = ztl$engine.$f("t3")
    val t4 = ztl$engine.$f("t4")
    val t5 = ztl$engine.$f("t5")
    runZTL(zscript, () => {
      click(jq("@button[label=\"Hide 1\"]"))
      waitResponse()
      verifyEquals(1, jq(".z-treerow:visible").length())
      verifyContains(jq(".z-treerow:visible").text(), "item5")
      click(jq("@button[label=\"Show 1\"]"))
      waitResponse()
      verifyEquals(5, jq(".z-treerow:visible").length())
      click(jq("@button[label=\"Hide 2\"]"))
      waitResponse()
      verifyEquals(3, jq(".z-treerow:visible").length())
      verifyContains(jq(".z-treerow:visible").text(), "item5")
      verifyContains(jq(".z-treerow:visible").text(), "item4")
      verifyContains(jq(".z-treerow:visible").text(), "item1")
      click(jq("@button[label=\"Show 2\"]"))
      waitResponse()
      verifyEquals(5, jq(".z-treerow:visible").length())
    })
  }
}



