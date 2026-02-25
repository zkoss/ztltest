import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2337652TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2337652TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
        It is correct if you see nothing but this line.
        <zscript>
          Window root = new Window();
	Grid grid = new Grid();
	grid.setId( "grid1" );
	root.appendChild( grid );
	root.removeChild( grid );

	grid = new Grid();
	grid.setId( "grid1" );
	root.appendChild( grid );
        </zscript>
      </window>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq("$grid1")[0])())
		.notOk("The grid should doesn't exists");
	await t
		.expect(await ClientFunction(() => !!jq(".z-msgbox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
