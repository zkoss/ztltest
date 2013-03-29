package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1597.zul")
class B65_ZK_1597Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
<zk>
	<window title="Hello World!!" border="normal" width="800px"
	height="500px">
		<zscript>ListModelList model = new ListModelList();
			model.add("a");
			model.add("b");
			model.add("c");</zscript>
		<tabbox hflex="1" vflex="1">
			<tabs>
				<tab id="tab" label="tab 1" droppable="true" draggable="true">
					<attribute name="onDrop">
						DropEvent evt = (DropEvent) event;
				Component dragged = evt.getDragged();
				Component target = evt.getTarget();
				dragged.getParent().insertBefore(dragged, target);
				dragged.selected= true;
					</attribute>
				</tab>
				<tab label="Items" draggable="true" droppable="true" id="tabItems">
					<attribute name="onDrop">
						DropEvent evt = (DropEvent) event;
				Component dragged = evt.getDragged();
				Component target = evt.getTarget();
				dragged.getParent().insertBefore(dragged, target);
				dragged.selected= true;
					</attribute>	
				</tab>
			</tabs>
			<tabpanels>
				<tabpanel>
				<label multiline="true">
				1, Please select the tab "Items".
				2, Drag the tab "Items" to prev of "tab 1" and drop it.
				3, The tab "Items" should be selected and the content displays the first tabpanel.
				</label>
				</tabpanel>
				<tabpanel>
					<borderlayout height="100%" width="100%">
						<north size="30px" flex="true" splittable="true" minsize="30" maxsize="30" >
							<combobox />
						</north>
						<center autoscroll="true">
							<listbox id="listbox" model="${model}" >
								<listhead>
									<listheader label="id" />
									<listheader label="descricao" />
								</listhead>
							</listbox>
						</center>
					</borderlayout>
				</tabpanel>
			</tabpanels>
		</tabbox>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val position = "2,2"
        val src = jq(".z-tab:contains(Items)")
        val target = jq(".z-tab:contains(tab 1)")
        mouseMoveAt(src, position)
        waitResponse

        mouseDownAt(src, position)
        waitResponse

        mouseMoveAt(target, position)
        waitResponse
        
        mouseUpAt(target, position)
        waitResponse
        
        
        verifyEquals("The tab 'Items' should be selected and the content displays the first tabpanel.", jq(".z-tab:eq(0)").text() == "Items")
        verifyEquals("The tab 'Items' should be selected and the content displays the first tabpanel.", jq(".z-tabpanel:eq(0) .z-label:contains(1)").exists())
      })

  }
}