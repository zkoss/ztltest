package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-3014.zul")
class B70_ZK_3014Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val bandboxButton = jq(".z-bandbox-button");
        click(bandboxButton);
        waitResponse(true);

        click(bandboxButton);
        val changeModelButton = jq(".z-button:contains(change model)");
        click(changeModelButton);

        click(bandboxButton);
        waitResponse(true);
        
        val listbox = jq(".z-listbox");
        verifyTrue(listbox.width() > 2);
      })
  }
}