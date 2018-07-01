package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2588.zul")
class B70_ZK_2588Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var treecells = jq(".z-treecell");
      click(treecells.eq(0));
      waitResponse();
      click(treecells.last());
      waitResponse();
      var before = getScrollTop(jq("@tree").toWidget());
      click(treecells.last());
      waitResponse();
      verifyTolerant(getScrollTop(jq("@tree").toWidget()), before, 1);

      var listcells = jq(".z-listcell");
      click(listcells.eq(0));
      waitResponse();
      click(listcells.last());
      waitResponse();
      before = getScrollTop(jq("@listbox").toWidget());
      click(listcells.last());
      waitResponse();
      verifyTolerant(getScrollTop(jq("@listbox").toWidget()), before, 1);
    })

  }
}