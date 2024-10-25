package tech.bam.dojo.shaderbackground

val NoiseGrain =
    """
    uniform float2 iResolution;
    uniform shader image; 
    uniform float intensity;
    
    vec4 main( vec2 fragCoord )
    {
        vec2 uv = fragCoord/iResolution.xy;
        
        // Check if pixel is inside viewport bounds
        if (fragCoord.x < 0.0 || fragCoord.x > iResolution.x || fragCoord.y < 0.0 || fragCoord.y > iResolution.y) {
            return vec4(image.eval(fragCoord));
        }

        float mdf = -0.8 * intensity; // increase for noise amount 
        float noise = (fract(sin(dot(uv, vec2(12.9898,78.233)*2.0)) * 43758.5453));
        vec4 tex = vec4(image.eval(fragCoord));
        
        mdf *= 1.5;
        
        vec4 col = tex - noise * mdf;

        return col;
    }
    """
