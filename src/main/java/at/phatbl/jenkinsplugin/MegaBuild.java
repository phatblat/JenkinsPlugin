package at.phatbl.jenkinsplugin;

import hudson.model.Build;
import hudson.model.FreeStyleProject;

import java.io.File;
import java.io.IOException;

/**
 * Created by phatblat on 6/27/17.
 */
public class MegaBuild extends Build<MegaProject, MegaBuild> {
    public MegaBuild(MegaProject project) throws IOException {
        super(project);
    }

    public MegaBuild(MegaProject project, File buildDir) throws IOException {
        super(project, buildDir);
    }

    @Override
    public void run() {
        execute(new MegaBuildExecution());
    }

    public class MegaBuildExecution extends Build.BuildExecution {
    }
}
