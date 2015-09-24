package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{ZK, Tags}
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2660.zul")
class B80_ZK_2660Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
  <zscript><![CDATA[
public class State {
  private String id, code, name;

  public State(String id, String code, String name) {
    super();
    this.id = id;
    this.code = code;
    this.name = name;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
ListModelList statesListModel = new ListModelList();
for (int i = 0; i < 10; i++) {
  statesListModel.add(new State("id" + i, "code " + i, "name " + i));
}
  ]]></zscript>
  <window vflex="1">
    <vlayout>
      <label multiline="true">
      1. Hide any column from the menupopup of listheader2
      2. Click "Show Listheader visibility", the visible state should sync with browser
      </label>
      <button label="Show Listheader visibility">
        <attribute name="onClick"><![CDATA[
          List headers = head.getChildren();
          String message = "";
          for (int i = 0, size = headers.size(); i < size; i++) {
            Listheader header = headers.get(i);
            message += "Column: " + header.getLabel() + ", Visible:" + header.isVisible() + "<br/>";
          }
          Clients.showNotification(message);
        ]]></attribute>
      </button>
      <listbox mold="paging" model="${statesListModel}" vflex="min">
        <listhead id="head" menupopup="auto" columnshide="true">
          <listheader width="40px" label="Id" />
          <listheader width="150px" label="Code" />
          <listheader width="150px" label="Name" />
        </listhead>
        <template name="model">
          <listitem>
            <listcell label="${each.id}" />
            <listcell label="${each.code}" />
            <listcell label="${each.name}" />
          </listitem>
        </template>
      </listbox>
    </vlayout>
  </window>
</zk>

""" 
  runZTL(zscript,
    () => {
      var header = jq(".z-listheader").last();
      var btn = jq(".z-listheader").last().find("a");
      //click(jq(".z-button"));
      click(header);
      waitResponse();
      mouseMoveAt(header, "1,1");
      if (ZK.is("ie9"))
        sleep(100)
      waitResponse();
      click(btn);
      waitResponse();
      click(jq(".z-menuitem-checked").first().find("a"));
      waitResponse();
      click(jq(".z-button"));
      waitResponse();
      verifyEquals("Column: Id, Visible:falseColumn: Code, Visible:trueColumn: Name, Visible:true", 
          jq(".z-notification-content").text());
    })
    
  }
}