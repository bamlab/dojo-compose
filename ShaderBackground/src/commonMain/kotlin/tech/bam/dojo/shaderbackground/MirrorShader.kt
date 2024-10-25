package tech.bam.dojo.shaderbackground

val MirrorShader = """
uniform shader image;
uniform float2 iResolution;

half4 main(float2 fragCoord) {
    // Check if the fragment is on the left or right side
    bool isLeftSide = fragCoord.x < iResolution.x / 2.0;

    // Mirror the X-coordinate if on the right side
    float2 mirroredCoord = isLeftSide 
                           ? fragCoord 
                           : float2(iResolution.x - fragCoord.x, fragCoord.y);

    // Sample the image at the mirrored coordinate
    return image.eval(mirroredCoord);
}
"""
