package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._

@Tags(tags = "B60-ZK-1126.zul")
class B60_ZK_1126Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?page title="new page title" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <html>
                      <![CDATA[
    <p>This demo illustrates how to move items from one listbox to another, and vice versa. You should see 
    three panels, each using a different underlying model representation.</p>
    <p>In each panel, you should see</p>
     
    <ol> 
    <li>two listboxes side by side</li>
    <li>left listbox initially populated with data "1"~"4".</li>
    <li>two buttons between the listboxes, used to move data between left and right listboxes.</li>
    </ol>
    
    <p>You should be able to select the data to move in any order. And the move should not cause any exceptions
    to occur.</p>
  ]]>
                    </html>
                    <zscript>
                      <![CDATA[
    import org.zkoss.zul.ext.*;
    
	  // ListModelList
    ListModelList list1 = new ListModelList();
    list1.add("1");
    list1.add("2");
    list1.add("3");
    list1.add("4");
    list1.setMultiple(true);
    
    ListModelList list2 = new ListModelList();
    list2.setMultiple(true);

    // ListModelSet
	  ListModelSet set1 = new ListModelSet();
	  set1.add("1");
	  set1.add("2");
	  set1.add("3");
	  set1.add("4");
	  set1.setMultiple(true);
	  
	  ListModelSet set2 = new ListModelSet();
	  set2.setMultiple(true);

	  // ListModelMap
	  ListModelMap map1 = new ListModelMap();
	  map1.put(1, "one");
	  map1.put(2, "two");
	  map1.put(3, "three");
	  map1.put(4, "four");
	  map1.setMultiple(true);
	  
	  ListModelMap map2 = new ListModelMap();
	  map2.setMultiple(true);
  ]]>
                    </zscript>
                    <tabbox>
                      <tabs>
                        <tab label="ListModelList"/>
                        <tab label="ListModelSet"/>
                        <tab label="ListModelMap"/>
                      </tabs>
                      <tabpanels>
                        <tabpanel>
                          <hlayout>
                            <listbox id="listbox1" model="${list1}" width="200px" multiple="true" checkmark="true">
                              <template name="model">
                                <listitem>
                                  <listcell label="${each}"/>
                                </listitem>
                              </template>
                            </listbox>
                            <vlayout>
                              <button label="&lt;-">
                                <attribute name="onClick">
                                  <![CDATA[
	              Set selectedItems = ((Selectable) listbox2.getModel()).getSelection();
	              ((ListModelList) listbox1.getModel()).addAll(selectedItems);
	              ((ListModelList) listbox2.getModel()).removeAll(selectedItems);
              ]]>
                                </attribute>
                              </button>
                              <button label="- &gt;">
                                <attribute name="onClick">
                                  <![CDATA[
	              Set selectedItems = ((Selectable) listbox1.getModel()).getSelection();
	              ((ListModelList) listbox2.getModel()).addAll(selectedItems);
	              ((ListModelList) listbox1.getModel()).removeAll(selectedItems);
              ]]>
                                </attribute>
                              </button>
                            </vlayout>
                            <listbox id="listbox2" model="${list2}" width="200px" multiple="true" checkmark="true">
                              <template name="model">
                                <listitem>
                                  <listcell label="${each}"/>
                                </listitem>
                              </template>
                            </listbox>
                          </hlayout>
                        </tabpanel>
                        <tabpanel>
                          <hlayout>
                            <listbox id="listbox3" model="${set1}" width="200px" multiple="true" checkmark="true">
                              <template name="model">
                                <listitem>
                                  <listcell label="${each}"/>
                                </listitem>
                              </template>
                            </listbox>
                            <vlayout>
                              <button label="&lt;-">
                                <attribute name="onClick">
                                  <![CDATA[
	              Set selectedItems = ((Selectable) listbox4.getModel()).getSelection();
	              ((ListModelSet) listbox3.getModel()).addAll(selectedItems);
	              ((ListModelSet) listbox4.getModel()).removeAll(selectedItems);
              ]]>
                                </attribute>
                              </button>
                              <button label="- &gt;">
                                <attribute name="onClick">
                                  <![CDATA[
	              Set selectedItems = ((Selectable) listbox3.getModel()).getSelection();
	              ((ListModelSet) listbox4.getModel()).addAll(selectedItems);
	              ((ListModelSet) listbox3.getModel()).removeAll(selectedItems);
              ]]>
                                </attribute>
                              </button>
                            </vlayout>
                            <listbox id="listbox4" model="${set2}" width="200px" multiple="true" checkmark="true">
                              <template name="model">
                                <listitem>
                                  <listcell label="${each}"/>
                                </listitem>
                              </template>
                            </listbox>
                          </hlayout>
                        </tabpanel>
                        <tabpanel>
                          <hlayout>
                            <listbox id="listbox5" model="${map1}" width="200px" multiple="true" checkmark="true">
                              <template name="model">
                                <listitem>
                                  <listcell label="${each.value}"/>
                                </listitem>
                              </template>
                            </listbox>
                            <vlayout>
                              <button label="&lt;-">
                                <attribute name="onClick">
                                  <![CDATA[
                Set selectedItems = ((Selectable) listbox6.getModel()).getSelection();
                Set keys = new HashSet();                
                for (Map.Entry entry : selectedItems) {
                	Integer key = (Integer) entry.getKey();
                	String value = (String) entry.getValue();
                	((ListModelMap) listbox5.getModel()).put(key, value);
                	keys.add(key);
                }
                
                for (Integer key : keys) {
                  ((ListModelMap) listbox6.getModel()).remove(key);
                }
              ]]>
                                </attribute>
                              </button>
                              <button label="- &gt;">
                                <attribute name="onClick">
                                  <![CDATA[
                Set selectedItems = ((Selectable) listbox5.getModel()).getSelection();
                Set keys = new HashSet();
                
                for (Map.Entry entry : selectedItems) {
                	Integer key = (Integer) entry.getKey();
                	String value = (String) entry.getValue();
                  ((ListModelMap) listbox6.getModel()).put(key, value);
                  keys.add(key);
                }
                
                for (Integer key : keys) {
                  ((ListModelMap) listbox5.getModel()).remove(key);
                }
                
              ]]>
                                </attribute>
                              </button>
                            </vlayout>
                            <listbox id="listbox6" model="${map2}" width="200px" multiple="true" checkmark="true">
                              <template name="model">
                                <listitem>
                                  <listcell label="${each.value}"/>
                                </listitem>
                              </template>
                            </listbox>
                          </hlayout>
                        </tabpanel>
                      </tabpanels>
                    </tabbox>
                  </zk>"""

    runZTL(zscript,
      () => {
        val tabs = List("ListModelMap", "ListModelSet", "ListModelList")

        tabs.foreach { tab =>
          click(jq(".z-tab:contains(" + tab + ")"))
          waitResponse()

          val panel = jq(".z-tabpanel:visible")
          val btn = panel.find(".z-button")
          val leftBox = panel.find(".z-listbox:eq(0)")
          val rightBox = panel.find(".z-listbox:eq(1)")
          verifyEquals("should see two listboxes side by side", jq(".z-tabpanel .z-listbox").length(), 2)
          verifyEquals("should see left listbox initially populated with data '1'~'4'.", jq(".z-tabpanel .z-listbox .z-listitem").length(), 4)
          verifyEquals("should see two buttons between the listboxes", btn.length(), 2)

          val hlayInn0 = leftBox.parents(".z-hlayout-inner").html()
          val hlayInn1 = btn.parents(".z-hlayout-inner").html()
          val hlayInn2 = rightBox.parents(".z-hlayout-inner").html()

          val hlayChild = jq(".z-hlayout").children().iterator().toList.map(_.html())
          val i0 = hlayChild.indexOf(hlayInn0)
          val i1 = hlayChild.indexOf(hlayInn1)
          val i2 = hlayChild.indexOf(hlayInn2)

          verifyTrue("should see two buttons between the listboxes", i0 < i1)
          verifyTrue("should see two buttons between the listboxes", i1 < i2)

          click(panel.find(".z-listitem-img-checkbox:eq(0)"))
          waitResponse()
          click(panel.find(".z-listitem-img-checkbox:eq(2)"))
          waitResponse()
          click(panel.find(".z-listitem-img-checkbox:eq(3)"))
          waitResponse()

          click(panel.find(".z-button:contains(- >)"))
          waitResponse()
          verifyTrue("should not cause any exceptions to occur.", !jq(".z-window-modal").exists())

          verifyEquals(" should be able to select the data to move in any order.", leftBox.find(".z-listitem").length(), 1)
          verifyEquals(" should be able to select the data to move in any order.", rightBox.find(".z-listitem").length(), 3)

          click(panel.find(".z-listitem-img-checkbox:eq(3)"))
          waitResponse()

          click(panel.find(".z-button:contains(<-)"))
          waitResponse()

          verifyTrue("should not cause any exceptions to occur.", !jq(".z-window-modal").exists())

          verifyEquals(" should be able to select the data to move in any order.", leftBox.find(".z-listitem").length(), 2)
          verifyEquals(" should be able to select the data to move in any order.", rightBox.find(".z-listitem").length(), 2)

        }

      })

  }
}
