/* B50_3287366Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3287366Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk>
	<html><![CDATA[
		<ol>
			<li>In first and second columns, you should see "A" in all 4 cells.</li>
			<li>Open the two Combobox on the right. You should see "A" as an option in each of the boxes.</li>
		</ol>
	]]></html>
	<zscript>
		String[] model = new String[] {"A"};
	</zscript>
	<grid model="@{model}">
		<rows>
			<row self="@{each=line}">
				<grid>
					<rows>
						<row>
							<label value="@{line}" />
						</row>
					</rows>
				</grid>
				<listbox>
					<listitem>
						<listcell>
							<label value="@{line}" />
						</listcell>
					</listitem>
				</listbox>
				<combobox>
					<comboitem label="@{line}" />
				</combobox>
			</row>
		</rows>
	</grid>
	<listbox model="@{model}">
		<listitem self="@{each=line}">
			<listcell>
				<grid>
					<rows>
						<row>
							<label value="@{line}" />
						</row>
					</rows>
				</grid>
			</listcell>
			<listcell>
				<listbox>
					<listitem>
						<listcell>
							<label value="@{line}" />
						</listcell>
					</listitem>
				</listbox>
			</listcell>
			<listcell>
				<combobox>
					<comboitem label="@{line}" />
				</combobox>
			</listcell>
		</listitem>
	</listbox>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyEquals("A", jq("@grid:eq(1) @row @label").text())
      verifyEquals("A", jq("@grid:eq(2) @row @label").text())
      verifyEquals("A", jq("@listbox @listitem:eq(0) @label:eq(0)").text())
      verifyEquals("A", jq("@listbox @listitem:eq(1) @label:eq(0)").text())
      click(jq("@combobox:eq(0)").toWidget().$n("btn"));
      waitResponse()
      var pp = jq(".z-combobox").toWidget().$n("pp")
      verifyContains(jq(pp).text(), "A")
      click(jq("@combobox:eq(0)").toWidget().$n("btn"));
      waitResponse()
      click(jq("@combobox:eq(1)").toWidget().$n("btn"));
      waitResponse()
      verifyContains(jq(pp).text(), "A")
    })
  }
}



