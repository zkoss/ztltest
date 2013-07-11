/* B35_2073409Test.scala

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
 * A test class for bug 1911129
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2073409.zul,A,E,Grid,Groupfoot")
class B35_2073409Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
    		<window title="Grid with Group feature" border="normal">
	1.Add a group , 2. add a group footer. any step should work as well.
	<zscript>
		<![CDATA[
		String[][] datas = new String[][]{
			// Today
			new String[]{"1","[zk1 - Help] RE: ZK problem in dynamicmenu","2008/4/29 15:47:27","12KB"},
			new String[]{"2","[zk1 - Help] RE: FileUpload","2008/4/2915:37:57","14KB"},
			new String[]{"3","[zk1 - Help] RE: Datebox format","2008/4/2915:27:31","11KB"},
			new String[]{"4","[zk1 - Help] RE: Datebox format","2008/4/2914:17:22","12KB"},
			new String[]{"5","[zk1 - Help] FileUpload","2008/4/2914:07:25","11KB"},
			new String[]{"6","[zk1 - General] RE: Opening more than one new	browserwindow","2008/4/29 13:44:17","12KB"},
			new String[]{"7","[zk1 - Help] RE: SelectedItemConverterQuestion","2008/4/29 13:31:12","14KB"},
			new String[]{"8","[zk1 - Help] RE: Times_Series Chart help","2008/4/2913:26:37","14KB"},
			new String[]{"9","[zk1 - Help] RE: Times_Series Chart help","2008/4/2910:41:33","14KB"},	
			new String[]{"10","[zk1 - Help] RE: SelectedItemConverterQuestion","2008/4/29 10:14:27","14KB"},
			// Yesterday
			new String[]{"11","[zk1 - General] RE: Opening more than onenew	browser window","2008/4/28 13:44:17","12KB"},
			new String[]{"12","[zk1 - Help] RE: SelectedItemConverterQuestion","2008/4/28 13:31:12","14KB"},
			new String[]{"13","[zk1 - Help] RE: Times_Series Chart help","2008/4/2813:26:37","14KB"},
			new String[]{"14","[zk1 - Help] RE: Times_Series Chart help","2008/4/2810:41:33","14KB"},	
			new String[]{"15","[zk1 - Help] RE: SelectedItemConverterQuestion","2008/4/28 10:14:27","14KB"},
			
		};
	]]>
	<![CDATA[//@DECLARATION
	Group gg;
	void addNewGroup(){
		Group group = new Group("Group1");
    	group.setId("group1");
		gg = group;
		Row row1 = new Row();
    	row1.setId("row1");
		new Label("row1").setParent(row1);
		Row row2 = new Row();
        row2.setId("row2");
		new Label("row2").setParent(row2);
		group.setOpen(false);
		myrows.getChildren().add(12,row2);
		myrows.getChildren().add(12,row1);
		myrows.getChildren().add(12,group);
	}
	void addFoot(){
		Groupfoot foot = new Groupfoot("footer");
        foot.setId("foot1");
try{
		myrows.getChildren().add(15,foot);
}catch(Exception x){
alert("Exception:"+x.getClass()+":"+x.getMessage());
}
	}
	]]>
	</zscript>
	<hbox>
		<button id="addgroup" label="1.add group " onClick="addNewGroup()"/>
		<button id="addfoot" label="2.add foot" onClick="addFoot()"/>
	</hbox>
	<grid>
        <columns sizable="true">
          <column width="200px" label="From"/>
          <column label="Subject"/>
          <column width="150px" label="Received"/>
          <column width="50px" label="Size"/>
        </columns>
        <rows id="myrows">
          <group open="false">
            <label value="Date:Today [From]"/>
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
          <groupfoot>
             <label value="10 emails"/>
             <label value="zk1"/>
             <label value="2008/4/29"/>
             <label value="128KB"/>
          </groupfoot>
          <group label="Date:Yesterday" />
          <row forEach="${datas}" forEachBegin="10" forEachEnd="14">
            <div><image style="padding: 0px 10px"
src="/test2/img/mail_read.png"/><label value="${each[0]}"/></div>
            <label value="${each[1]}"/>
            <label value="${each[2]}"/>
            <label value="${each[3]}"/>
          </row>
          <groupfoot>
            <label value="5 emails"/>
            <label value="zk1"/>
            <label value="2008/4/28"/>
            <label value="68KB"/>
          </groupfoot>
          <group label="Date:Sunday 1" />
           <groupfoot>
            <label value="5 emails"/>
            <label value="zk1"/>
            <label value="2008/4/28"/>
            <label value="68KB"/>
          </groupfoot>
          <group label="Date:Sunday 1" />
           <groupfoot>
            <label value="5 emails"/>
            <label value="zk1"/>
            <label value="2008/4/28"/>
            <label value="68KB"/>
          </groupfoot>
          <group label="Date:Sunday 2" />
        </rows>
      </grid>
	
</window>
    """

    runZTL(zscript,
        () => {
        
        	waitResponse();
                  	
        	//1. Add group button
        	val b1=jq("$addgroup");
        	click(b1);
        	
        	waitResponse();
        	
        	val gr1=jq("$group1");
        	val txt=getText(gr1);
        	
        	//Group1 exists
        	verifyEquals(txt,"Group1");

        	//Click group to open
        	val cl=jq("$group1").find("span");
        	click(cl); 
        	
        	waitResponse();
        	
        	//Verify if new rows exists in group
        	val row0=jq("$row1");
        	val row1=jq("$row2");
        	
        	verifyTrue(row0.exists());
        	verifyTrue(row1.exists());
        	
        	//Verify if group open works well (rows are visible)
        	verifyTrue(row0.isVisible());
        	verifyTrue(row1.isVisible());
        	
        	//2. Add foot button
        	val b2=jq("$addfoot");
        	click(b2);
        	
        	waitResponse();
        	
        	val foot1=jq("$foot1");
        	val txt1=getText(foot1);
        	
        	//Foot1 exists
        	verifyEquals(txt1,"footer");
        	        	
        }
    );
   }
}
