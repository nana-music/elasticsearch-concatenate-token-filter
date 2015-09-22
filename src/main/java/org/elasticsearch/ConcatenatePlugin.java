package org.elasticsearch.plugin.concatenate;

import java.util.Collection;

import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;

public class ConcatenatePlugin extends AbstractPlugin {
    @Override
    public String name() {
        return "concatenate-token-filter";
    }

    @Override
    public String description() {
        return "concatenate token filter plugin";
    }
}
