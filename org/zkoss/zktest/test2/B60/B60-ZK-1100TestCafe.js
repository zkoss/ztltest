import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1100TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1100TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <zscript>
                      String image1 = "/img/Centigrade-Widget-Icons/ArrowDown-16x16.png";
		String image2 = "/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png";

		void changeImage(boolean setMenuImage){

                        miImage.setImage(image2);
                        miImage2.setImage(image2);
                        if (setMenuImage) {
                          menuImage.setImage(image2);
                          menuImage.setHoverImage("/img/Centigrade-Widget-Icons/ArrowLeftGreen-16x16.png");
                        }
                      }
                    </zscript>
                    <div>1. Click \'Image\' then \'setImage\', the image if \'setImage\' should changed from down arrow to left arrow.</div>
                    <div>2. Click \'Image\' then \'setImage2\', the image of \'Image\' should changed from down arrow to left arrow.</div>
                    <div></div>
                    <menubar id="menubar">
                      <menuitem id="miImage" image="\${image1}" hoverImage="/img/Centigrade-Widget-Icons/ArrowLeftGreen-16x16.png"/>
                      <menu label="Image" id="menuImage">
                        <menupopup>
                          <menuitem id="miImage2" label="setImage" onClick="changeImage(false)" hoverImage="/img/Centigrade-Widget-Icons/ArrowLeftGreen-16x16.png" image="\${image1}"/>
                          <menuitem label="setImage2" onClick="changeImage(true)" hoverImage="/img/Centigrade-Widget-Icons/ArrowLeftGreen-16x16.png" image="\${image1}"/>
                        </menupopup>
                      </menu>
                    </menubar>
                  </zk>`,
	);
	await t.click(Selector(() => jq(".z-menu:contains(Image)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem:contains(setImage)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-menuitem:eq(0) .z-menuitem-image[src*=Left]")[0],
			)(),
		)
		.ok(
			"1. Click 'Image' then 'setImage', the image if 'setImage' should changed from down arrow to left arrow.",
		);
	await t.click(Selector(() => jq(".z-menu:contains(Image)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem:contains(setImage2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-menu:contains(Image)")).$n("img")).is(
					"[src*=Left]",
				),
			)(),
		)
		.ok(
			"2. Click 'Image' then 'setImage2', the image of 'Image' should changed from down arrow to left arrow.",
		);
});
