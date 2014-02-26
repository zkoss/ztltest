/* B36_3049167Test.scala

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
package org.zkoss.zktest.test2.B36

import java.util.Calendar
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.junit.Test

/**
 * A test class for bug 3049167
 * @author ldnigro
 *
 */
@Tags(tags = "B36-3049167.zul,A,E,Listbox,Grid,DragDrop")
class B36_3049167Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """
<zk><html>
<![CDATA[
	<p>1. Drag Listitem inside the listbox to reorder the sequence.</p>
	<p>2. Check the total size of the listitems shown on the paging bar (original is 8).</p>
	<p>3. If you saw the total size change(increase) after you drag and reorder the listitem, it is a bug.</p>
]]>
	</html>
	<hbox>
		<listbox id="left" height="250px" width="250px" onDrop="move(event.dragged)" droppable="listitem"
			oddRowSclass="non-odd" mold="paging" pageSize="5">
			<listitem draggable="listitem" droppable="listitem" onDrop="move(event.dragged)">
				<listcell src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" label="ZK Forge" />
			</listitem>
			<listitem draggable="listitem" droppable="listitem" onDrop="move(event.dragged)"> 
				<listcell src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" label="ZK Mobile" />
			</listitem>
			<listitem draggable="listitem" droppable="listitem" onDrop="move(event.dragged)">
				<listcell src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" label="ZK GWT" />
			</listitem>
			<listitem draggable="listitem" droppable="listitem" onDrop="move(event.dragged)">
				<listcell src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" label="ZK JSF" />
			</listitem>
			<listitem draggable="listitem" droppable="listitem" onDrop="move(event.dragged)">
				<listcell src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" label="ZK JSP" />
			</listitem>
			<listitem draggable="listitem" droppable="listitem" onDrop="move(event.dragged)">
				<listcell src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" label="ZK Spring" />
			</listitem>
			<listitem draggable="listitem"  droppable="listitem" onDrop="move(event.dragged)">
				<listcell src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" label="ZK" />
			</listitem>
			<listitem draggable="listitem"  droppable="listitem" onDrop="move(event.dragged)">
				<listcell src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png" label="ZK Studio" />
			</listitem>
		</listbox>
		<grid height="250px" width="250px" onDrop="move(event.dragged)" droppable="grid" 
			oddRowSclass="non-odd" mold="paging" pageSize="5">
			<rows>
			<row draggable="grid" droppable="grid" onDrop="move(event.dragged)">
				<label value="ZK Forge" />
			</row>
			<row draggable="grid" droppable="grid" onDrop="move(event.dragged)"> 
				<label value="ZK Mobile" />
			</row>
			<row draggable="grid" droppable="grid" onDrop="move(event.dragged)">
				<label value="ZK GWT" />
			</row>
			<row draggable="grid" droppable="grid" onDrop="move(event.dragged)">
				<label value="ZK JSF" />
			</row>
			<row draggable="grid" droppable="grid" onDrop="move(event.dragged)">
				<label value="ZK JSP" />
			</row>
			<row draggable="grid" droppable="grid" onDrop="move(event.dragged)">
				<label value="ZK Spring" />
			</row>
			<row draggable="grid"  droppable="grid" onDrop="move(event.dragged)">
				<label value="ZK" />
			</row >
			<row draggable="grid"  droppable="grid" onDrop="move(event.dragged)">
				<label value="ZK Studio" />
			</row>
			</rows>
		</grid>
	</hbox>
	<zscript>
	void move(Component dragged) {
		if (self instanceof Listitem || self instanceof Row) {
			self.parent.insertBefore(dragged, self.getNextSibling());
		} else if (self instanceof Grid) {
			self.getRows().appendChild(dragged);
		} else {
			self.appendChild(dragged);
		}
	}
	</zscript>
</zk>

      """

    runZTL(zscript,
      () => {

        //Listbox
        waitResponse();

        //Get element ZK Forge
        //Get element ZK GWT
        var item0 = jq(".z-listbox-body .z-listcell:eq(0)");
        var item2 = jq(".z-listbox-body .z-listcell:eq(2)");
        
        waitResponse();
        
        var pos=item2.positionLeft()+","+item2.positionTop();
        
        dragAndDrop(item0,pos);
                
        waitResponse();
        
        var info=jq(".z-listbox .z-paging-info");
        var infotxt=getText(info);
        var original="[ 1 - 5 / 8 ]";
        
        //Verify qty
        verifyEquals(infotxt,original);
        
        //Grid
        waitResponse();

        //Get element ZK Forge
        //Get element ZK GWT
        var item01 = jq(".z-grid .z-label:eq(0)");
        var item12 = jq(".z-grid .z-label:eq(2)");
        
        waitResponse();
        
        dragAndDrop(item01,pos);
                
        waitResponse();
        
        var info1=jq(".z-grid .z-paging-info");
        var infotxt1=getText(info1);
        var original1="[ 1 - 5 / 8 ]";
        
        //Verify qty
        verifyEquals(infotxt1,original1);
                
      });
  }
     
}