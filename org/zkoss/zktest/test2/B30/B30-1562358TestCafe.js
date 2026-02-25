import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1562358TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1562358TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<groupbox mold="3d" width="400px"> 
				<caption label="Groupbox With Wrong Width in IE"/>
				<grid id="grid" height="200px" sizedByContent="true"> <!--workaround: style="overflow:auto"-->
					<rows>
						<row id="row">
						(make sure blabla is all on one line - that is it does not
						wrap) 
						blablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla		 
						</row> 
					</rows> 	 
				</grid> 
			</groupbox>`,
	);
});
