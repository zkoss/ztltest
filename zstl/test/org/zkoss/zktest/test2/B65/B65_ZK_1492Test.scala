package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1492.zul")
class B65_ZK_1492Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <label multiline="true">
                      1.select on comobobx1 by mouse, the onSelect and onChange should has same selection on model and selected item
		2.select on combobox2 by mouse, the onSelect and onChange should has same model selection
		  (it fail on 2 if the bug is not fixed, you will see model selection always show previous selection if you don't call 
		  combobox.getSelectedItem in onChange)
                    </label>
                    <zscript><![CDATA[//@DECRATION
	    class Item {
	    	String name;
	    	public Item(String name) { this.name = name; }
	    	public String getName() { return name; }
	    }
		
		java.util.List list = new java.util.ArrayList();
		list.add(new Item("option 1"));
		list.add(new Item("option 2"));
		list.add(new Item("option 3"));
		list.add(new Item("option 4"));
		list.add(new Item("option 5"));
		org.zkoss.zul.ListModelList lm1 = new org.zkoss.zul.ListModelList(list);
		org.zkoss.zul.ListModelList lm2 = new org.zkoss.zul.ListModelList(list);
		void onSelect(org.zkoss.zul.Combobox cb, boolean showSelectedComponent) {
			org.zkoss.zul.ListModelList m = cb.getModel();
			String msg;
			java.util.Set selection = m.getSelection();
			org.zkoss.zul.Comboitem selectedItem = showSelectedComponent?cb.getSelectedItem():null;
			if(selection.size()>0){
				Item sel = m.getSelection().iterator().next();
				msg = "model selection : "+ sel.name;
			}else{
				msg = "no model selection";
			}
			msg += ", combox value : "+cb.getValue();
			if(showSelectedComponent){
				msg += ", selected item : "+(selectedItem==null?"null":selectedItem.getValue().name);
			}
			msg += ":"+new java.util.Date();
			lb1.setValue(msg);
		}
		void onChange(org.zkoss.zul.Combobox cb, boolean showSelectedComponent) {
			org.zkoss.zul.ListModelList m = cb.getModel();
			String msg;
			java.util.Set selection = m.getSelection();
			org.zkoss.zul.Comboitem selectedItem = showSelectedComponent?cb.getSelectedItem():null;
			if(selection.size()>0){
				Item sel = m.getSelection().iterator().next();
				msg = "model selection : "+ sel.name;
			}else{
				msg = "no model selection";
			}
			msg += ", combox value : "+cb.getValue();
			if(showSelectedComponent){
				msg += ", selected item : "+(selectedItem==null?"null":selectedItem.getValue().name);
			}
			msg += ":"+new java.util.Date();
			lb2.setValue(msg);
		}
	]]></zscript>
                    <hlayout>
                      <vlayout>
                        <combobox id="cb1" model="${lm1}" onSelect='onSelect(cb1,true)' onChange='onChange(cb1,true)'>
                          <template name="model">
                            <comboitem label="${each.name}"/>
                          </template>
                        </combobox>
                        <combobox id="cb2" model="${lm2}" onSelect='onSelect(cb2,false)' onChange='onChange(cb2,false)'>
                          <template name="model">
                            <comboitem label="${each.name}"/>
                          </template>
                        </combobox>
                      </vlayout>
                      <vlayout>
                        <hlayout>onSelect:<label id="lb1"/></hlayout>
                        <hlayout>onChange:<label id="lb2"/></hlayout>
                      </vlayout>
                    </hlayout>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-combobox:eq(0)").toWidget().$n("btn"))
        waitResponse()
        click(jq(".z-comboitem:contains(2)"))
        waitResponse()
        
        // the text should be "model selection : option 2, combox value : option 2, selected item : option 2:Wed Dec 19 14:59:55 CST 2012"
        val combo1text1 = jq("$lb1").text().substring(0, 77)
        // the text should be "model selection : option 2, combox value : option 2, selected item : option 2:Wed Dec 19 14:59:55 CST 2012"
        val combo1text2 = jq("$lb2").text().substring(0, 77)
        
        verifyEquals(combo1text1.count(_ == '2'), 3)
        verifyEquals(combo1text2.count(_ == '2'), 3)
        
        click(jq(".z-combobox:eq(1)").toWidget().$n("btn"))
        waitResponse()
        click(jq(".z-comboitem:contains(1):eq(1)"))
        waitResponse()
        
        // the text should be "model selection : option 1, combox value : option 1:Wed Dec 19 15:00:36 CST 2012"
        val combo2text1 = jq("$lb1").text().substring(0, 51)
        // the text should be "model selection : option 1, combox value : option 1:Wed Dec 19 15:00:36 CST 2012"
        val combo2text2 = jq("$lb2").text().substring(0, 51)
        
        verifyEquals(combo2text1.count(_ == '1'), 2)
        verifyEquals(combo2text2.count(_ == '1'), 2)
      })

  }
}
