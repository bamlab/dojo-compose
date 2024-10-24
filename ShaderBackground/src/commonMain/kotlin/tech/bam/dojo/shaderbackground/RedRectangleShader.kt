package tech.bam.dojo.shaderbackground

val RedRectangleShader = """
    
uniform float2 iResolution;              // viewport resolution (in pixels)
const half4 color1a = half4(0.086, 0.196, 0.357, 1.0);  // #16325B
half4 main(vec2 fragCoord) { 
    return half4(color1a.rgb * fragCoord.x / iResolution.x, 1.0);
}
"""
