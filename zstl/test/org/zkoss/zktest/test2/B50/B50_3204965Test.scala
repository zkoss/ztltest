/* B50_3204965Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 11:13:17 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug 3204965
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3204965.zul,A,E,Listbox,Grid,Tree")
class B50_3204965Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
    			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
				<html><![CDATA[
					<ol>
						<li>Click on "Resize" Button. The number after "Page Size:" should change. Otherwise it is a bug.</li>
					</ol>
				]]></html>
				<zscript><![CDATA[
					rows = new String[50];
					for(int i = 0; i < 50; i++)
						rows[i] = "Row " + i;
				]]></zscript>
				<vlayout>
					<button id="btn" label="Resize" onClick='myWin.height="500px"' />
					<div>
						Page Size:
						<textbox disabled="true" id="tb" />
					</div>
				</vlayout>
				<window id="myWin" height="200px" width="500px" border="normal">
					<listbox id="list" vflex="1" model="@{rows}" mold="paging" autopaging="true">
						<attribute name="onPageSize">
							tb.value = "" + self.pageSize;
						</attribute>
						<listitem self="@{each=r}">
							<listcell>
								<label value="@{r}" />
							</listcell>
						</listitem>
					</listbox>
				</window>
			</zk>

    """

    def executor = () => {
      var btn: Widget = engine.$f("btn");
      var tb: Widget = engine.$f("tb");
      waitResponse();
      var size1: Int = parseInt(tb.$n().get("value"));
      click(btn);
      waitResponse();
      var size2: Int = parseInt(tb.$n().get("value"));
      verifyNotEquals(size1, size2);
    }

    runZTL(zscript, executor);

  }
}