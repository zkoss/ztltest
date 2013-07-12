/* B35_2073420Test.scala

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
import org.junit.Test

/**
 * A test class for bug 2073420
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2073420.zul,A,E,Grid,Group,Groupfoot")
class B35_2073420Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
    		<zk>
<vbox>
1.click "updateGroup1", the label changed to a Icon<separator/>
2.then click again. the samll open icon of group header(a [+] or [arrow]) should NOT disappear.
</vbox>

<window title="Grid with Group feature" border="normal">
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
<![CDATA[//@DECLARATION

void updateGroup(Group g1){
g1.getChildren().clear();
Image img=new Image("/test2/img/inet.png");
img.setId("img1");
img.setParent(g1);
new Label("group 1").setParent(g1);
Menubar mb = new Menubar();
mb.setParent(g1);
new Menuitem("File").setParent(mb);
new Menuitem("Help").setParent(mb);
g1.setSpans("1,1,2");

}

void updateFoot(Groupfoot f1){
f1.getChildren().clear();
Image img=new Image("/test2/img/inet.png");
img.setId("img1");
img.setParent(f1);
new Label("group 1").setParent(f1);
Menubar mb = new Menubar();
mb.setParent(f1);
new Menuitem("File").setParent(mb);
new Menuitem("Help").setParent(mb);
f1.setSpans("1,1,2");
}

void removeGroup(Group g1){
g1.detach();
}

void removeFoot(Groupfoot f1){
f1.detach();
}

]]>
</zscript>
<div>
<button id="upd1" label="1.updateGroup 1" onClick="updateGroup(g1)"/>
</div>
<grid id="gd">
<columns sizable="true">
<column width="200px" label="From"/>
<column label="Subject"/>
<column width="150px" label="Received"/>
<column width="50px" label="Size"/>
</columns>
<rows id="myrows">
<group open="false" id="g1">
<label id="lbl1" value="Date:Today [From]"/>
<label value="[Subject]"/>
<label value="[Received]"/>
<label value="[Size]"/>
</group>
<row forEach="${datas}" forEachBegin="0" forEachEnd="9">
<div><image style="padding: 0px 10px"
src="/test2/img/mail_read.png"/><label value="${each[0]}"/></div>
<label value="${each[1]}"/>
<label value="${each[2]}"/>
<label value="${each[3]}"/>
</row>
<groupfoot id="f1">
<label value="10 emails"/>
<label value="zk1"/>
<label value="2008/4/29"/>
<label value="128KB"/>
</groupfoot>
<group label="Date:Yesterday" id="g2"/>
<row forEach="${datas}" forEachBegin="10" forEachEnd="14">
<div><image style="padding: 0px 10px"
src="/test2/img/mail_read.png"/><label value="${each[0]}"/></div>
<label value="${each[1]}"/>
<label value="${each[2]}"/>
<label value="${each[3]}"/>
</row>
<groupfoot id="f2">
<label value="5 emails"/>
<label value="zk1"/>
<label value="2008/4/28"/>
<label value="68KB"/>
</groupfoot>
<group label="Date:Sunday 1" id="g3"/>
<groupfoot id="f3">
<label value="5 emails"/>
<label value="zk1"/>
<label value="2008/4/28"/>
<label value="68KB"/>
</groupfoot>
<group label="Date:Sunday 1" id="g4"/>
<groupfoot id="f4">
<label value="5 emails"/>
<label value="zk1"/>
<label value="2008/4/28"/>
<label value="68KB"/>
</groupfoot>
<group label="Date:Sunday 2" id="g5"/>
</rows>
</grid>

</window>
</zk>
    """

    runZTL(zscript,
        () => {
        
        	waitResponse();
                  
        	//Group1 Label
        	val lbl1=jq("$lbl1");
        	verifyTrue(lbl1.exists());
        	
        	//1. Update Group 1
        	val b1=jq("$upd1");
        	click(b1);
        	
        	waitResponse();
        	
        	//Group1 label change to Image 
        	val lbl2=jq("$lbl1");
        	verifyFalse(lbl1.exists());
        	
        	val img1=jq("$img1");
        	val ex=img1.exists();
        	verifyTrue(ex);
        	val img1c=jq("$g1").find("$img1");
        	val ex1=img1c.exists();
        	//Image parent is group1
        	verifyTrue(ex1);
        	        	
        	//2. Update Group 1 again
        	val b2=jq("$upd1");
        	click(b2);
        	
        	waitResponse();
        	
        	//Group arrow exists
        	val cl=jq("$g1").find("span");
        	verifyTrue(cl.exists());
        	        	        	
        }
    );
   }
}
