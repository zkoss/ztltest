/* B50_2948829Test.java

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


class B50_2948829Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" ?>
<div>
<html><![CDATA[
Test environment: ZK EE
<ol>
	<li>Click the dropdown button</li>
	<li>Click the icon before "level 1.1" to see if two more items are shown (level 1.1.1 and level 1.1.2)</li>
	<li>Click the "ZK" tab to see if "The second tabpanel" is shown</li>
</ol>
]]></html>

<bandbox>
<bandpopup>
<tree width="100%" style="border:0px;" height="100%">
	<treechildren style="background-image: url(${c:encodeURL('/img/gradient2.jpg')});">
	 	<treeitem open="true">
		 	<treerow>
			 	<treecell label="Start"
	             			style="color:#15428b; font-weight:bold; font-size:11px" />
			</treerow>
			<treechildren
					style="background-image: url(${c:encodeURL('/img/gradient2.jpg')});">
				<treeitem open="true">
					<treerow>
						<treecell
							label="level 1"
							style="color:#15428b; font-weight:bold; font-size:11px" />
						</treerow>
						<treechildren
								style="background-image: url(${c:encodeURL('/img/gradient2.jpg')});">
				 			<treeitem open="false">
								<treerow>
									<treecell
										label="level 1.1"
										style="color:#15428b; font-weight:bold; font-size:11px" />
								</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell
													label="level 1.1.1"
													style="color:#15428b; font-weight:bold; font-size:11px" />
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell
													label="level 1.1.2"
													style="color:#15428b; font-weight:bold; font-size:11px" />
											</treerow>
										</treeitem>	
									</treechildren>
								</treeitem>
								<treeitem>
									<treerow>
										<treecell
											label="level 1.2"
											style="color:#15428b; font-weight:bold; font-size:11px" />
									</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell
													label="level 1.2.1"
													style="color:#15428b; font-weight:bold; font-size:11px" />
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell
													label="level 1.2.2"
													style="color:#15428b; font-weight:bold; font-size:11px" />
											</treerow>
										</treeitem>	
									</treechildren>
								</treeitem>
						</treechildren>	
				</treeitem>
			</treechildren>
		</treeitem>
	</treechildren>	
</tree>
<tabbox width="300px">
	<tabs>
		<tab id="tab1" label="AJAX"/>
		<tab id="tab2" label="ZK"/>
	</tabs>
	<tabpanels>
		<tabpanel id="p1">
The first tabpanel
		</tabpanel>
		<tabpanel id="p2">
The second tabpanel
		</tabpanel>
	</tabpanels>
</tabbox>
</bandpopup>
</bandbox>	
						
</div>

			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tab1 = ztl$engine.$f("tab1")
    val tab2 = ztl$engine.$f("tab2")
    val p1 = ztl$engine.$f("p1")
    val p2 = ztl$engine.$f("p2")
    runZTL(zscript, () => {
      click(jq(".z-bandbox").toWidget().$n("btn"))
      waitResponse()
      verifyEquals(1, jq(".z-treerow:contains(level 1.1)").length())
      click(jq(".z-treerow:contains(level 1.1)").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(3, jq(".z-treerow:contains(level 1.1)").length())
      verifyContains(jq(".z-treerow:eq(3)").text(), "level 1.1.1")
      verifyContains(jq(".z-treerow:eq(4)").text(), "level 1.1.2")
      verifyEquals(1, jq(".z-tabpanel").length())
      click(tab2)
      waitResponse()
      verifyEquals(2, jq(".z-tabpanel").length())
      verifyFalse(isVisible(jq(".z-tabpanel:eq(0)")))
      verifyTrue(isVisible(jq(".z-tabpanel:eq(1)")));
    })
  }
}



