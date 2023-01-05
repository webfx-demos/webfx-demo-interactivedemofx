// File managed by WebFX (DO NOT EDIT MANUALLY)
package webfx.demo.demofxkitchensink.application.gwt.embed;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import dev.webfx.platform.resource.spi.impl.gwt.GwtResourceBundleBase;

public interface EmbedResourcesBundle extends ClientBundle {

    EmbedResourcesBundle R = GWT.create(EmbedResourcesBundle.class);
    @Source("com/chrisnewland/demofx/images/apple.png")
    TextResource r1();

    @Source("com/chrisnewland/demofx/images/banana.png")
    TextResource r2();

    @Source("com/chrisnewland/demofx/images/flake.png")
    TextResource r3();

    @Source("com/chrisnewland/demofx/images/orange.png")
    TextResource r4();

    @Source("com/chrisnewland/demofx/images/pear.png")
    TextResource r5();

    @Source("com/chrisnewland/demofx/images/pineapple.png")
    TextResource r6();

    @Source("com/chrisnewland/demofx/images/satsuma.png")
    TextResource r7();

    @Source("com/chrisnewland/demofx/images/star.png")
    TextResource r8();

    @Source("com/chrisnewland/demofx/images/strawberry.png")
    TextResource r9();

    @Source("com/chrisnewland/demofx/images/tomato.png")
    TextResource r10();

    @Source("com/chrisnewland/demofx/text/greetings.txt")
    TextResource r11();

    @Source("dev/webfx/platform/meta/exe/exe.properties")
    TextResource r12();



    final class ProvidedGwtResourceBundle extends GwtResourceBundleBase {
        public ProvidedGwtResourceBundle() {
            registerResource("com/chrisnewland/demofx/images/apple.png", R.r1());
            registerResource("com/chrisnewland/demofx/images/banana.png", R.r2());
            registerResource("com/chrisnewland/demofx/images/flake.png", R.r3());
            registerResource("com/chrisnewland/demofx/images/orange.png", R.r4());
            registerResource("com/chrisnewland/demofx/images/pear.png", R.r5());
            registerResource("com/chrisnewland/demofx/images/pineapple.png", R.r6());
            registerResource("com/chrisnewland/demofx/images/satsuma.png", R.r7());
            registerResource("com/chrisnewland/demofx/images/star.png", R.r8());
            registerResource("com/chrisnewland/demofx/images/strawberry.png", R.r9());
            registerResource("com/chrisnewland/demofx/images/tomato.png", R.r10());
            registerResource("com/chrisnewland/demofx/text/greetings.txt", R.r11());
            registerResource("dev/webfx/platform/meta/exe/exe.properties", R.r12());

        }
    }
}
