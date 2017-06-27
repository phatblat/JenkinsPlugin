package at.phatbl.jenkinsplugin;

import hudson.model.FreeStyleBuild;
import hudson.model.ItemGroup;
import hudson.model.Project;

/**
 * Created by phatblat on 6/27/17.
 */
public class MegaProject extends Project<MegaProject, MegaBuild> {
    public MegaProject(ItemGroup parent, String name) {
        super(parent, name);
    }

    @Override
    protected Class<MegaBuild> getBuildClass() {
        return MegaBuild.class;
    }
}
