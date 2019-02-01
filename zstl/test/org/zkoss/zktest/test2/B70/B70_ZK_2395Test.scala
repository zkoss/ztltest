package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2395.zul")
class B70_ZK_2395Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val check = () => {
          val tree = jq("@tree");
          val listbox = jq("@listbox");
          val grid = jq("@grid");
          verifyTolerant(tree.eq(0).find("@treecol").last().offsetLeft(),
            tree.eq(0).find("@treerow").first().find("@treecell").last().offsetLeft(), 1)
          verifyTolerant(tree.eq(1).find("@treecol").last().offsetLeft(),
            tree.eq(1).find("@treerow").first().find("@treecell").last().offsetLeft(), 1)

          verifyTolerant(listbox.eq(0).find("@listheader").last().offsetLeft(),
              listbox.eq(0).find("@listitem").first().find("@listcell").last().offsetLeft(), 1)
          verifyTolerant(listbox.eq(1).find("@listheader").last().offsetLeft(),
              listbox.eq(1).find("@listitem").first().find("@listcell").last().offsetLeft(), 1)

          verifyTolerant(grid.eq(0).find("@column").last().offsetLeft(),
              grid.eq(0).find("@row").first().find(".z-row-inner").last().offsetLeft(), 1)
          verifyTolerant(grid.eq(1).find("@column").last().offsetLeft(),
              grid.eq(1).find("@row").first().find(".z-row-inner").last().offsetLeft(), 1)
        };
        sleep(3000);
        check();

        click(jq("@button").eq(0));
        waitResponse();
        click(jq("@button").eq(2));
        waitResponse();
        check();

        click(jq("@button").eq(1));
        waitResponse();
        click(jq("@button").eq(3));
        waitResponse();
        check();
      })

  }
}