/* B35_2075723Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 2075723
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2075723.zul,A,E,Panel,Tablelayout")
class B35_2075723Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
    		<?xml version="1.0" encoding="UTF-8"?>
<zk>
<html><![CDATA[
1. minimize table 3. <br />
2. minimize table 1. <br />
3. maximize table 1, <br />
4. table 3 should be able to maximize again
]]></html>
<tablelayout id="tbl" columns="3" width="500px">
	<tablechildren id="tc1" colspan="2">
		<panel id="table1" title="table1" border="normal" maximizable="true" maximized="true"
			 collapsible="true">
			<panelchildren>
				<tablelayout columns="3">
					<tablechildren>
						<panel id="table31" title="table3" border="normal" maximizable="true" maximized="true" collapsible="true">
							<panelchildren>
								<label value="Panel3" />
							</panelchildren>
						</panel>
					</tablechildren>
				</tablelayout>
				Panel
			</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table2" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel2</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren rowspan="2">
		<panel id="table3" title="table3" border="normal" maximizable="true" maximized="true"
			 collapsible="true">
			<panelchildren>Panel3</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table4" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table5" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table6" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table7" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table8" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
</tablelayout>
</zk>
    """

    runZTL(zscript,
      () => {

        waitResponse();

        //Minimize table 3
        var table3 = jq("$table3").find("@panel").toWidget().$n("exp");
        click(table3);

        waitResponse(true);

        verifyFalse(jq(jq("$table3").toWidget().$n("body")).isVisible());

        //Minimize table 3-1
        var table31 = jq("$table31").find("@panel").toWidget().$n("exp");
        click(table31);

        waitResponse(true);

        verifyFalse(jq(jq("$table31").toWidget().$n("body")).isVisible());

        //Minimize table 1
        var table1 = jq("$table1").find("@panel").toWidget().$n("exp");
        click(table1);

        waitResponse(true);
        verifyFalse(jq(jq("$table31").toWidget().$n("body")).isVisible());
        verifyFalse(jq(jq("$table1").toWidget().$n("body")).isVisible());

        //Maximize table 1
        click(table1);

        waitResponse(true);

        verifyTrue(jq(jq("$table1").toWidget().$n("body")).isVisible());
        verifyFalse(jq(jq("$table31").toWidget().$n("body")).isVisible());

        //Maximize table 3-1
        click(table31);

        waitResponse(true);

        verifyTrue(jq(jq("$table1").toWidget().$n("body")).isVisible());
        verifyTrue(jq(jq("$table31").toWidget().$n("body")).isVisible());

        //Maximize table 3
        click(table3);

        waitResponse(true);
        verifyTrue(jq(jq("$table3").toWidget().$n("body")).isVisible());


      }
    );
  }
}
