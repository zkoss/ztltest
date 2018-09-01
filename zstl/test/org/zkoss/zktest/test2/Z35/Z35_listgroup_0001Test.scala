/* Z35_listgroup_0001Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.Z35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class Z35_listgroup_0001Test extends ZTL4ScalaTestCase {
  @Test
  def testgroupModelTest() = {
    var zscript =
      """
			<window title="Live Data Demo" border="normal">
				<![CDATA[
					Grouping with Live Data - Different Model should has different grouping
				]]>
				<zscript>
					<![CDATA[
					//@DECLARATION
					
					class MyComparator implements Comparator {
						boolean _asc;
						
						public MyComparator(boolean asc) {
							_asc = asc;
						}
						
						public int compare(Object o1, Object o2) {
							//Row row1 = (Row)o1;
							//Row row2 = (Row)o2;
							String s1 = (String)o1;//row1.getChildren().get(0).getValue();
							String s2 = (String)o2;//row2.getChildren().get(0).getValue();
							int v = s1.compareTo(s2);
							return _asc ? v: -v;
						}
					}
					
					class MyRenderer implements ListitemRenderer{
						public void render(Listitem listitem, java.lang.Object data, int index){
							Listcell cell = new Listcell();
							cell.setParent(listitem);
							if(data instanceof String[]){
								new Label(((String[])data)[0].toString()).setParent(cell);
							}else if (data instanceof String){
								new Label(data.toString()).setParent(cell);
							}else{
								new Label("UNKNOW:"+data.toString()).setParent(cell);
							}
						}
					}
					MyRenderer renderer = new MyRenderer();
					]]>
				</zscript>
				<zscript>
					<![CDATA[
						String[][] datas = new String[4][];
						datas[0] = new String[15];
						datas[1] = new String[14];
						datas[2] = new String[27];
						datas[3] = new String[33];
						for(int j=0; j<datas[0].length; ++j) {
							datas[0][j] = j+"A option "+j;
						}
						for(int j=0; j<datas[1].length; ++j) {
							datas[1][j] = j+"B option "+j;
						}
						for(int j=0; j<datas[2].length; ++j) {
							datas[2][j] = j+"C option "+j;
						}
						for(int j=0; j<datas[3].length; ++j) {
							datas[3][j] = j+"D option "+j;
						}
						GroupsModel model1 = new SimpleGroupsModel(datas);
						GroupsModel model2 = new SimpleGroupsModel(datas, new String[]{"Group A", "Group B", "Group C", "Group D"});
						GroupsModel model3 = new SimpleGroupsModel(datas, new String[]{"Group A", "Group B", "Group C", "Group D"}, new String[]{"Foot A", "Foot B", "Foot C", "Foot D"});
						GroupsModel model4 = new SimpleGroupsModel(datas, new String[]{"Group A", "Group B", "Group C", "Group D"}, new String[]{"Foot A1", null, "Footer C1", null});
						GroupsModel model5 = new SimpleGroupsModel(datas, new String[]{"Group A", "Group B", "Group C", "Group D"}, new String[]{null, "Foot B2", null, "Footer D2"});
									
						Comparator asc = new MyComparator(true);
						Comparator dsc = new MyComparator(false);
					]]>
				</zscript>
				<hbox>
					<button id="model1Btn" onClick="lb1.setModel(model1);" label="data only" />
					<button id="model2Btn" onClick="lb1.setModel(model2)" label="data ,head" />
					<button id="model3Btn" onClick="lb1.setModel(model3)" label="data,head,foot" />
					<button id="model4Btn" onClick="lb1.setModel(model4)" label="not all foot" />
					<button id="model5Btn" onClick="lb1.setModel(model5)" label="not all foot 2" />
					<button id="pagingBtn" onClick='lb1.setMold("paging");lb1.setPageSize(7)'
						label="set Paging" />
					<button id="invalidateBtn" onClick="lb1.invalidate();" label="invalidate" />
					<button id="clearBtn" onClick="lb1.getChildren().clear();" label="Any time clear() wont cause exceptions(not paging mold)" />
				</hbox>
				<custom-attributes org.zkoss.zul.listbox.rod="false" />
				<listbox id="lb1" width="500px" height="500px" model="${model2}"
					itemRenderer="${renderer}">
					<listhead>
						<listheader label="Load on Demend" sortAscending="${asc}"
							sortDescending="${dsc}" />
					</listhead>
				</listbox>
			</window>
		"""
    val ztl$engine = engine()
    val model1Btn = ztl$engine.$f("model1Btn")
    val model2Btn = ztl$engine.$f("model2Btn")
    val model3Btn = ztl$engine.$f("model3Btn")
    val model4Btn = ztl$engine.$f("model4Btn")
    val model5Btn = ztl$engine.$f("model5Btn")
    val pagingBtn = ztl$engine.$f("pagingBtn")
    val invalidateBtn = ztl$engine.$f("invalidateBtn")
    val clearBtn = ztl$engine.$f("clearBtn")
    val lb1 = ztl$engine.$f("lb1")
    runZTL(zscript, () => {
      // data only
      click(model1Btn);
      waitResponse();
      var model1VerifyStr = jq("tr.z-listgroup:eq(0)").text();
      verifyContains("jq('tr.z-listgroup:eq(0)').text(): " +
        model1VerifyStr, model1VerifyStr, "option")
      // data, head
      click(model2Btn)
      waitResponse();
      var model2VerifyStr = jq("tr.z-listgroup:eq(0)").text()
      verifyContains("jq('tr.z-listgroup:eq(0)').text(): " +
        model2VerifyStr, model2VerifyStr, "Group")
      // data, head, foot
      click(model3Btn);
      waitResponse()
      var footerQty = jq("tr.z-listgroupfoot").length();
      verifyTrue("jq('tr.z-listgroupfoot').length(): " +
        footerQty, footerQty == 4);
      // not all foot
      click(model4Btn)
      waitResponse();
      footerQty = jq("tr.z-listgroupfoot").length()
      verifyTrue("jq('tr.z-listgroupfoot').length(): " +
        footerQty, footerQty == 2)
      var footerStr = jq("tr.z-listgroupfoot:eq(0)").text();
      verifyContains("jq('tr.z-listgroupfoot:eq(0)'): " +
        footerStr, footerStr, "A1")
      // not all foot 2
      click(model5Btn)
      waitResponse();
      footerQty = jq("tr.z-listgroupfoot").length()
      verifyTrue("jq('tr.z-listgroupfoot').length(): " +
        footerQty, footerQty == 2)
      click(jq("tr.z-listgroup:eq(0)").toWidget().$n("img"))
      waitResponse();
      sleep(300);
      footerStr = jq("tr.z-listgroupfoot:eq(0)").text()
      verifyContains("jq('tr.z-listgroupfoot:eq(0)'): " +
        footerStr, footerStr, "B2")
      // Clear without any exceptions
      click(clearBtn);
      waitResponse()
      verifyFalse("Here should not display any message dialog.",
        jq("div.z-window-modal").exists())
      // set Paging
      click(pagingBtn);
      waitResponse()
      verifyTrue("Set paging failed", jq("div.z-paging").exists());
      // invalidate
      click(invalidateBtn)
      waitResponse();
      verifyTrue("The screen cannot has any change after clicking invalidate", jq("div.z-paging").exists())
    })
  }
}



