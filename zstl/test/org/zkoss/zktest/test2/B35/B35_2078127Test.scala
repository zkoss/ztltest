/* B35_2078127Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 17, 2011 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B35-2078127.zul,B,E,Window,Button")
class B35_2078127Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk>
        <vbox>
          1.click updateGroup 1, then click again. the [+] should not disappear.
          <separator/>
          2.click updateFoot 1, then click again. the style of words should remain the same.
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

void updateGroup(Listgroup g1){
g1.getChildren().clear();

Listcell c1 = new Listcell("1");
c1.setParent(g1);
Listcell c2 = new Listcell("2");
c2.setParent(g1);
Listcell c3 = new Listcell("3");
c3.setParent(g1);
Listcell c4 = new Listcell();
c4.setParent(g1);
Menubar mb = new Menubar();
mb.setParent(c4);
new Menuitem("File").setParent(mb);
new Menuitem("Help").setParent(mb);
//g1.setSpans("1,1,2");

}

void updateFoot(Listgroupfoot f1){
f1.getChildren().clear();

Listcell c1 = new Listcell("1");
c1.setParent(f1);
Listcell c2 = new Listcell("2");
c2.setParent(f1);
Listcell c3 = new Listcell("3");
c3.setParent(f1);
Listcell c4 = new Listcell();
c4.setParent(f1);
Menubar mb = new Menubar();
mb.setParent(c4);
new Menuitem("File").setParent(mb);
new Menuitem("Help").setParent(mb);
}

void removeGroup(Listgroup g1){
g1.detach();
}

void removeFoot(Listgroupfoot f1){
f1.detach();
}

]]>
          </zscript>
          <div>
            <button label="1.updateGroup 1" onClick="updateGroup(g1)"/>
            <button label="2.updateFoot 1" onClick="updateFoot(f1)"/>
          </div>
          <listbox id="gd">
            <listhead sizable="true">
              <listheader width="150px" label="From" sort="auto"/>
              <listheader label="Subject" sort="auto"/>
              <listheader width="150px" label="Received" sort="auto"/>
              <listheader width="50px" label="Size" sort="auto"/>
            </listhead>
            <listgroup id="g1">
              <listcell label="Date:Today [From]"/>
              <listcell label="[Subject]"/>
              <listcell label="[Received]"/>
              <listcell label="[Size]"/>
            </listgroup>
            <listitem forEach="${datas}" forEachBegin="0" forEachEnd="9">
              <listcell label="${each[0]}" image="/test2/img/mail_read.png" sclass="mailitem"/>
              <listcell label="${each[1]}"/>
              <listcell label="${each[2]}"/>
              <listcell label="${each[3]}"/>
            </listitem>
            <listgroupfoot id="f1">
              <listcell label="10 emails"/>
              <listcell label="zk1"/>
              <listcell label="2008/4/29"/>
              <listcell label="128KB"/>
            </listgroupfoot>
            <listgroup label="Date:Yesterday" id="g2"/>
            <listitem forEach="${datas}" forEachBegin="10" forEachEnd="14">
              <listcell label="${each[0]}" image="/test2/img/mail_read.png" sclass="mailitem"/>
              <listcell label="${each[1]}"/>
              <listcell label="${each[2]}"/>
              <listcell label="${each[3]}"/>
            </listitem>
            <listgroupfoot id="f2">
              <listcell label="5 emails"/>
              <listcell label="zk1"/>
              <listcell label="2008/4/28"/>
              <listcell label="68KB"/>
            </listgroupfoot>
            <listgroup label="Date:Sunday"/>
            <listitem forEach="${datas}" forEachBegin="15" forEachEnd="20">
              <listcell label="${each[0]}" image="/test2/img/mail_read.png" sclass="mailitem"/>
              <listcell label="${each[1]}"/>
              <listcell label="${each[2]}"/>
              <listcell label="${each[3]}"/>
            </listitem>
            <listgroupfoot id="f4">
              <listcell label="5 emails"/>
              <listcell label="zk1"/>
              <listcell label="2008/4/28"/>
              <listcell label="68KB"/>
            </listgroupfoot>
          </listbox>
        </window>
      </zk>
    }
    runZTL(zscript, () => {
      // Click on updateGroup1 button
      click(jq("@button").get(0));
      waitResponse();

      // Click again
      click(jq("@button").get(0));
      waitResponse();

      // Verify that the '+' icon is present
      // Don't know why jq(".z-listgroup-img .z-listgroup-img-open") does't return the element
      verifyTrue("The '+' icon should be visible", jq(".z-listcell-cnt:contains(1)").html().contains("z-listgroup-img z-listgroup-img-open"));

      // Record style attributes
      val css1Before = jq(".z-listcel-cnt").css("font-weight");
      val css2Before = jq(".z-listcel-cnt").css("font-size");
      val css3Before = jq(".z-listcel-cnt").css("font-family");
      val css4Before = jq(".z-listcel-cnt").css("font-color");

      // Click on updateFoot1 button
      click(jq("@button").get(1));
      waitResponse();

      // Click again
      click(jq("@button").get(1));
      waitResponse();

      // Record style attributes again
      val css1After = jq(".z-listcel-cnt").css("font-weight");
      val css2After = jq(".z-listcel-cnt").css("font-size");
      val css3After = jq(".z-listcel-cnt").css("font-family");
      val css4After = jq(".z-listcel-cnt").css("font-color");

      verifyTrue("The font-weight should be equal than before", css1Before.equals(css1After));
      verifyTrue("The font-size should be equal than before", css2Before.equals(css2After));
      verifyTrue("The font-family should be equal than before", css3Before.equals(css3After));
      verifyTrue("The font-color should be equal than before", css4Before.equals(css4After));
    })
  }
}