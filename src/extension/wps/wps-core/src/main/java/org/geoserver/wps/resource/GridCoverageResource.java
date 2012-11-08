package org.geoserver.wps.resource;

import org.geoserver.wcs.CoverageCleanerCallback;
import org.opengis.coverage.grid.GridCoverage;

/**
 * A resource managing the lifecycle of a {@link GridCoverage} and disposing of it when the process is complete
 * 
 * @author Andrea Aime - GeoSolutions
 */
public class GridCoverageResource implements WPSResource {

    private GridCoverage coverage;

    public GridCoverageResource(GridCoverage coverage) {
        this.coverage = coverage;
    }

    @Override
    public void delete() throws Exception {
        CoverageCleanerCallback.disposeCoverage(coverage);
    }

    @Override
    public String getName() {
        return "Coverage - " + coverage;
    }

}