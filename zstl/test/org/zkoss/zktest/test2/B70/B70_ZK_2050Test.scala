package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2050.zul")
class B70_ZK_2050Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window sclass="ie8" title="IE8 Only" border="normal">
	<label multiline="true">
		1. Select the checkmark in the listhead.
		2. All the listitem should be selected.
		3. Scroll to the bottom, all the checkmark should not out of position.
	</label>
	<listbox mold="paging" autopaging="true" multiple="true" checkmark="true" height="780px">
    <custom-attributes org.zkoss.zul.listbox.rod="false"/>
		<listhead>
			<listheader label="aaa"></listheader>
			<listheader label="aaa"></listheader>
			<listheader label="aaa"></listheader>
			<listheader label="aaa"></listheader>
		</listhead>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
		<listitem>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
			<listcell label="askdjfhk"></listcell>
		</listitem>
	</listbox>
</window>"""  
  runZTL(zscript,
    () => {
			//spec changes, no "check all" checkbox anymore since zk8
			verifyTrue(true)
/*      click(jq(".z-listheader-checkable"))
      waitResponse()
      
      val iter = jq(".z-listitem").iterator()
      var hasSelected = true
      while (iter.hasNext() && hasSelected) {
        val jq = iter.next()
        hasSelected = jq.hasClass("z-listitem-selected")
      }
        
      verifyTrue("All the listitem should be selected.", hasSelected)*/
    })
    
  }
}