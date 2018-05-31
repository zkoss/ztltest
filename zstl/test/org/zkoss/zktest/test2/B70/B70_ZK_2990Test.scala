package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2990.zul")
class B70_ZK_2990Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val button = jq(".z-button:contains(Show notification!)");
        click(button);
        waitResponse(true);

        val winCloseButton = jq(".z-window-close");
        click(winCloseButton);
        waitResponse();

        val notification = jq(".z-notification");
        val notificationCloseButton = notification.find(".z-notification-close");
        click(notificationCloseButton);
        waitResponse(true);

        verifyFalse(notification.isVisible());
      })

  }
}