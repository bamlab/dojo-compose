package tech.bam.dojo.shaderbackground

val GradientShader = """
layout(color) uniform half4 color1a;
layout(color) uniform half4 color1b;
layout(color) uniform half4 color2a;
layout(color) uniform half4 color2b;

uniform float2 iResolution;              // viewport resolution (in pixels)
uniform float iTime;                     // shader playback time (in seconds)


// Function to replace the `#define` macro
float S(float a, float b, float t) {
    return smoothstep(a, b, t);
}

mat2 Rot(float a)
{
    float s = sin(a);
    float c = cos(a);
    return mat2(c, -s, s, c);
}

float2 hash(float2 p)
{
    p = float2(dot(p, float2(2127.1, 81.17)), dot(p, float2(1269.5, 283.37)));
    return fract(sin(p) * 43758.5453);
}

float noise(float2 p)
{
    float2 i = floor(p);
    float2 f = fract(p);

    float2 u = f * f * (3.0 - 2.0 * f);

    float n = mix(mix(dot(-1.0 + 2.0 * hash(i + float2(0.0, 0.0)), f - float2(0.0, 0.0)),
                      dot(-1.0 + 2.0 * hash(i + float2(1.0, 0.0)), f - float2(1.0, 0.0)), u.x),
                  mix(dot(-1.0 + 2.0 * hash(i + float2(0.0, 1.0)), f - float2(0.0, 1.0)),
                      dot(-1.0 + 2.0 * hash(i + float2(1.0, 1.0)), f - float2(1.0, 1.0)), u.x), u.y);
    return 0.5 + 0.5 * n;
}

half4 main(float2 fragCoord)
{
    float2 uv = fragCoord / iResolution.xy;
    float ratio = iResolution.x / iResolution.y;

    float2 tuv = uv;
    tuv -= 0.5;

    // Rotate with Noise
    float degree = noise(float2(iTime * 0.1, tuv.x * tuv.y));

    tuv.y *= 1.0 / ratio;
    tuv *= Rot(radians((degree - 0.5) * 720.0 + 180.0));
    tuv.y *= ratio;

    // Wave warp with sin
    float frequency = 5.0;
    float amplitude = 30.0;
    float speed = iTime * 2.0;
    tuv.x += sin(tuv.y * frequency + speed) / amplitude;
    tuv.y += sin(tuv.x * frequency * 1.5 + speed) / (amplitude * 0.5);

    // Draw the image
    float3 layer1 = mix(color1a.rgb, color1b.rgb, S(-0.3, 0.2, (tuv * Rot(radians(-5.0))).x));
    float3 layer2 = mix(color2a.rgb, color2b.rgb, S(-0.3, 0.2, (tuv * Rot(radians(-5.0))).x));

    float3 finalComp = mix(layer1, layer2, S(0.5, -0.3, tuv.y));

    float3 col = finalComp;

    return half4(col, 1.0);
}

"""
