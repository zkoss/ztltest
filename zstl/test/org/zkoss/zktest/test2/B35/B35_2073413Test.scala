/* B35_2073413Test.scala

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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * A test class for bug 2073413
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2073413.zul,A,E,Grid,Detail")
class B35_2073413Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
    		<window title="Grid with Group feature" border="normal">
<groupbox open="false"><caption label="instructions(click to open)"/><html><![CDATA[  
	1.Open any group, then open any detail .<br/>
	2.Close groups that you opened. Then all rows and opened details in this group should be hide.<br/>
	3.Open the group again, the rows and opened details should show again.<br/>
	4.A un-opened detail never showup, no matter certain group be opened or closeed.<br/>
	]]></html></groupbox>
	<zscript>
<![CDATA[
String[][] datas = new String[][]{
// Today
new String[]{"1","[zk1 - Help] RE: ZK problem in dynamic menu","2008/4/29 15:47:27","12KB"},
new String[]{"2","[zk1 - Help] RE: FileUpload","2008/4/29 15:37:57","14KB"},
new String[]{"3","[zk1 - Help] RE: Datebox format","2008/4/29 15:27:31","11KB"},
new String[]{"4","[zk1 - Help] RE: Datebox format","2008/4/29 14:17:22","12KB"},
new String[]{"5","[zk1 - Help] FileUpload","2008/4/29 14:07:25","11KB"},
new String[]{"6","[zk1 - General] RE: Opening more than one new browser window","2008/4/29 13:44:17","12KB"},
new String[]{"7","[zk1 - Help] RE: SelectedItemConverter Question","2008/4/29 13:31:12","14KB"},
new String[]{"8","[zk1 - Help] RE: Times_Series Chart help","2008/4/29 13:26:37","14KB"},
new String[]{"9","[zk1 - Help] RE: Times_Series Chart help","2008/4/29 10:41:33","14KB"},
new String[]{"10","[zk1 - Help] RE: SelectedItemConverter Question","2008/4/29 10:14:27","14KB"},
// Yesterday
new String[]{"11","[zk1 - General] RE: Opening more than one new browser window","2008/4/28 13:44:17","12KB"},
new String[]{"12","[zk1 - Help] RE: SelectedItemConverter Question","2008/4/28 13:31:12","14KB"},
new String[]{"13","[zk1 - Help] RE: Times_Series Chart help","2008/4/28 13:26:37","14KB"},
new String[]{"14","[zk1 - Help] RE: Times_Series Chart help","2008/4/28 10:41:33","14KB"},
new String[]{"15","[zk1 - Help] RE: SelectedItemConverter Question","2008/4/28 10:14:27","14KB"},

};
]]>
</zscript>
	<grid>
		<columns sizable="true">
			<column width="35px" label="open" />
			<column width="200px" label="From" />
			<column label="Subject" />
			<column width="150px" label="Received" />
			<column width="50px" label="Size" />
		</columns>
		<rows id="myrows">
			<group id="today" open="false">
				<label value="" />
				<label value="Date:Today [From]" />
				<label value="[Subject]" />
				<label value="[Received]" />
				<label value="[Size]" />
			</group>
			<row forEach="${datas}" forEachBegin="0" forEachEnd="9" id="row${each[0]}">
				<detail  id="detail${each[0]}">
					<hbox id="gp${each[0]}">
						<label value="${each[1]}" />
						<label value="${each[2]}" />
						<label value="${each[3]}" />
					</hbox>
				</detail>
				<div>
					<image style="padding: 0px 10px" src="/test2/img/mail_read.png" />
					<label value="${each[0]}" />
				</div>
				<label value="${each[1]}" />
				<label value="${each[2]}" />
				<label value="${each[3]}" />
			</row>
			<groupfoot>
				<label value="" />
				<label value="10 emails" />
				<label value="zk1" />
				<label value="2008/4/29" />
				<label value="128KB" />
			</groupfoot>
			<group id="yesterday" label="Date:Yesterday" />
			<row forEach="${datas}" forEachBegin="10" forEachEnd="14" id="row${each[0]}">
				<detail id="detail${each[0]}">
					<groupbox mold="3d" id="gp${each[0]}">
						<caption>title</caption>
						<label value="${each[1]}" />
						<label value="${each[2]}" />
						<label value="${each[3]}" />
					</groupbox>
				</detail>
				<div>
					<image style="padding: 0px 10px" src="/test2/img/mail_read.png" />
					<label value="${each[0]}" />
				</div>
				<label value="${each[1]}" />
				<label value="${each[2]}" />
				<label value="${each[3]}" />
			</row>
			<groupfoot>
				<label value="" />
				<label value="5 emails" />
				<label value="zk1" />
				<label value="2008/4/28" />
				<label value="68KB" />
			</groupfoot>
		</rows>
	</grid>

</window>
    """

    runZTL(zscript,
        () => {
        
        	waitResponse();
                  
        	//Group1 Open
        	var t=jq("$today span");
        	click(t);
        	        	
        	waitResponse();
        	
        	//Group2 Open
        	var y=jq("$yesterday span");
        	//click(y);
        	
        	waitResponse();

        	//Check if rows are visible
        	for(i <- 1 to 15) {
        		var row=jq("$row"+i);
        		var vis=row.isVisible();
        		verifyTrue(vis);

        		//Open any detail
        		var det= widget(jq("$row" + i + " @detail")).$n("icon");
        		click(det);
        		waitResponse();
        		
        		//Verify detail is visible
        		var detail=jq("$gp"+i);
        		var detv=detail.isVisible();
        		verifyTrue(detv);
        		
        	}
        	
        	//Group1 Close
        	t=jq("$today span");
        	click(t);
        	waitResponse();
        	
        	//Group2 Close
        	y=jq("$yesterday span");
        	click(y);
        	waitResponse();
        	
        	//Check if rows are invisible
        	for(i <- 1 to 15) {
        		var row=jq("$row"+i);
        		var vis=row.isVisible();
        		verifyFalse(vis);
        		
        		//Verify detail is invisible
        		var detail=jq("$gp"+i);
        		var detv=detail.isVisible();
        		verifyFalse(detv);
        	}
        	
        	//Group1 Open
        	t=jq("$today span");
        	click(t);
        	waitResponse();
        	
        	//Group2 Open
        	y=jq("$yesterday span");
        	click(y);
        	waitResponse();
        	
        	//Check if rows & details are visible
        	for(i <- 1 to 15) {
        		var row=jq("$row"+i);
        		var vis=row.isVisible();
        		verifyTrue(vis);
        		
        		//Verify detail is visible
        		var detail=jq("$gp"+i);
        		var detv=detail.isVisible();
        		verifyTrue(detv);
        	}
        	
        	
        	//Close detail to check unopen never showup
        	var det= widget(jq("$row14 @detail")).$n("icon");
        	click(det);
        	waitResponse();
        	
        	//Group2 close
        	y=jq("$yesterday span");
        	click(y);
        	waitResponse();
        	
        	//Group2 Open
        	y=jq("$yesterday span");
        	click(y);
        	waitResponse();
        	
        	//Check if detail still unopen
        	val dt=jq("$gp14");
        	val dv=dt.isVisible();
        	verifyFalse(dv);
        	
        }
    );
   }
}
